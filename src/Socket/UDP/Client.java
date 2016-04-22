package Socket.UDP;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 
 * 描述：模拟的客户端
 * @author gt
 * @created 2016年4月21日 上午10:22:30
 * @since
 */
public class Client {
    public static void main(String[] args) throws IOException {
		//创建客户端+端口,这里客户端端口需要指定，也可以不指定,如果不指定，就会任意分配可用的接口
    	DatagramSocket client = new DatagramSocket();
    	//准备数据
//    	String msg = "顾涛爱倪贝";
//    	byte[] data = msg.getBytes();
    	//测试带有类型的数据传输
    	double num = 88.88;
    	byte[] data = convert(num);
    	//打包数据
    	DatagramPacket packet = new DatagramPacket(data, 0, data.length, new InetSocketAddress("localhost", 8888));
	    //发送
    	client.send(packet);
    	//关闭资源
    }
    public static byte[] convert(double num) throws IOException{
    	byte[] data = null;
    	//为了返回成字节数组
    	ByteArrayOutputStream out = new ByteArrayOutputStream();
    	//处理流
    	DataOutputStream dataout = new DataOutputStream(out);
    	dataout.writeDouble(num);
    	data = out.toByteArray();
    	dataout.flush();
    	return data;
    }
}
