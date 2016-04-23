package Socket.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 
 * 描述：服务器端,这里目前只支持一个客户端接入
 * @author gt
 * @created 2016年4月22日 下午2:55:02
 * @since
 */
public class MultiServer {
   public static void main(String[] args) throws IOException {
	 //创建服务器端，指定监听端口为9999
	 ServerSocket server = new ServerSocket(9999);
     //接收，一个客户端对应一个accept()
	 Socket socket = server.accept();
	 //创建输入流和输出流，用于接收客户端的消息和转发客户端的消息
	 DataInputStream in = new DataInputStream(socket.getInputStream());
	 DataOutputStream out = new DataOutputStream(socket.getOutputStream());
	 while (true) {
	    //介绍消息
	    String info = in.readUTF();
	    System.out.println("服务器接收到消息:"+info);
	    out.writeUTF("服务器返回:"+info);
	    out.flush();
     }
   }
}
