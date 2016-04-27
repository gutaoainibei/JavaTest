package Socket.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import TestIO.FileUtils;
/**
 * 
 * 描述：服务器端,这里目前只支持一个客户端接入
 * @author gt
 * @created 2016年4月22日 下午2:55:02
 * @since
 */
public class MultiServer {
   private  ArrayList<Mychannel> channel_list = new ArrayList<Mychannel>();
   public static void main(String[] args) throws IOException {
	  new MultiServer().start();
   }
   public void start() throws IOException{
	   //创建服务器端，指定监听端口为9999
		 ServerSocket server = new ServerSocket(9999);
	     //接收，一个客户端对应一个accept()
		 int i = 0;
		 while(true){
			 i++;
			 Socket socket = server.accept();
			 Mychannel channel = new Mychannel(socket,"gutao"+i);
			 channel_list.add(channel);
			 Thread thread = new Thread(channel);
			 thread.start();
		 }
	   
   }
   class Mychannel implements Runnable{
	    private DataInputStream in;
	    private DataOutputStream out;
	    private String name;
	    private boolean isRunning = true;
	    public Mychannel(Socket client,String name){
	    	try {
				this.in = new DataInputStream(client.getInputStream());
				this.out = new DataOutputStream(client.getOutputStream());
				this.name = name;
			} catch (IOException e) {
				isRunning = false;
				FileUtils.CloseAll(in,out);
				e.printStackTrace();
			}
	    }
	    /**
	     * 描述：用于接收，客户端信息
	     * @author gt
	     * @created 2016年4月26日 下午3:52:42
	     * @since
	     */
	    public String receive(){
	    	String info = "";
	    	try {
				info = in.readUTF();
				System.out.println("服务器接收到数据："+info);
			} catch (IOException e) {
				isRunning = false;
				e.printStackTrace();
			}
	    	return info;
	    }
	    public void send(String msg){
	    	if (null == msg || msg.equals("")) {
				return;
			}
	    	try {
				out.writeUTF(msg);
				out.flush();
			} catch (IOException e) {
				isRunning = false;
				channel_list.remove(this);
				e.printStackTrace();
			}
	    }
	    /**
	     * 描述：向客户端发送信息
	     * @author gt
	     * @created 2016年4月26日 下午3:53:40
	     * @since
	     */
	    public void sendOthers(){
	    	String msg = receive();
	    	for (Mychannel now_channel : channel_list) {
				if (now_channel == this) {//如果是本管道就跳过不发
					continue;
				}
				//当前线程拥有者向其他用户发出的消息,向向线程发过去
				now_channel.send(name+"说："+msg);
			}
	    }
		@Override
		public void run() {
			while (isRunning) {
				sendOthers();
			}
		}
	}
}
