package Socket.TCP;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 
 * 描述：基于tcp协议的客户端
 * @author gt
 * @created 2016年4月22日 上午10:00:07
 * @since
 */
public class Client {
    public static void main(String[] args) throws IOException {
    	//创建客户端，开始时就建立连接，如果连接不上
    	//java.net.ConnectException: Connection refused: connect
		Socket client = new Socket("localhost",8888);
		//接收数据
		BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
	    String msg = reader.readLine();//阻塞式方法
		System.out.println(msg);
	    reader.close();
//		DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
//	    String msg = dataInputStream.readUTF();
//		System.out.println(msg);
    }
}
