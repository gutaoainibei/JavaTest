package Socket;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * 
 * 描述：测试InetSocketAddress类
 * @author gt
 * @created 2016年4月20日 下午4:00:46
 * @since
 */
public class InetSocketAddressTest1 {
     public static void main(String[] args) {
		InetSocketAddress address = new InetSocketAddress("127.0.0.1", 80);
		System.out.println(address.getHostName());
		System.out.println(address.getPort());
	    InetAddress add1 = address.getAddress();
	    System.out.println(add1.getHostAddress());
	    System.out.println(add1.getHostName());
	}
}
