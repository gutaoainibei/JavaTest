package Socket.server;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * 描述：实现自己简单服务器
 * @author gt
 * @created 2016年4月24日 下午10:58:37
 * @since
 */
public class MyServer {
    private ServerSocket server;
    public static void main(String[] args) {
		MyServer serverTest = new MyServer();
		serverTest.start();
	}
    /**
     * 
     * 描述：启动服务器
     * @author gt
     * @created 2016年4月25日 下午11:37:53
     * @since
     */
    private void start(){
    	try {
			server = new ServerSocket(8888);
			this.receive();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    /**
     * 
     * 描述：接受请求
     * @author gt
     * @created 2016年4月25日 下午11:37:57
     * @since
     */
    private void receive(){
    	try {
			Socket simple_socket = server.accept();
			 StringBuffer stringBuffer = new StringBuffer();
			//如果是post方式这里就是不对的，这里我们是按行在读，但是post方式会有空行
			//所以还是用字节流比较好这里
//			BufferedReader reader = new BufferedReader(new InputStreamReader(simple_socket.getInputStream()));
//		    
//			String msg = "";   
//		    while ((msg=reader.readLine()).length()>0) {
//				stringBuffer.append(msg);
//				stringBuffer.append("\r\n");
//				if (msg==null) {
//					break;
//				}
//			}
			BufferedInputStream inputStream = new BufferedInputStream(simple_socket.getInputStream());
			byte[] flush = new byte[1024];
			int len = inputStream.read(flush);
		    System.out.println("获取到的请求信息：");
		    System.out.println(new String(flush,0,len));
    	} catch (IOException e) {
			e.printStackTrace();
		}
    }
    /**
     * 
     * 描述：停止服务器
     * @author gt
     * @created 2016年4月25日 下午11:38:02
     * @since
     */
    private void stop(){
    	
    }
}
