package Socket.chat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 * 描述：客户端
 * @author gt
 * @created 2016年4月22日 下午2:55:15
 * @since
 */
public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
    	//连接服务器
		Socket client = new Socket("localhost", 9999);
		new Thread(new Send(client)).start();
		new Thread(new Receive(client)).start();
	}
}
