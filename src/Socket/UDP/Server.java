package Socket.UDP;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 
 * 描述：模拟的服务器端
 * @author gt
 * @created 2016年4月21日 上午10:22:13
 * @since
 */
public class Server {
    public static void main(String[] args) throws IOException {
    	//创建服务端
		DatagramSocket server = new DatagramSocket(8888); 
	    //准备容器接收数据
		byte[] data = new byte[1024];
	    //封装成包DatagramPacket
		DatagramPacket packet = new DatagramPacket(data, 0, data.length);
		//接收数据放到packet中
		server.receive(packet);
//		byte[] pdata = packet.getData();
//		int len = packet.getLength();
//		//分析数据
//		System.out.println(new String(pdata,0,len));
		System.out.println(packet.getAddress()+":"+packet.getPort());
		double num = convert(packet.getData());
		//关闭服务端
		System.out.println(num);
		server.close();
    }
    public static double convert(byte[] data) throws IOException{
    	ByteArrayInputStream in = new ByteArrayInputStream(data);
    	DataInputStream dataout = new DataInputStream(in);
    	double num = dataout.readDouble();
    	dataout.close();
    	return num;
    }
}
