package Socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 
 * 描述：测试InetAddress的方法，这里这个类的构造函数没有暴露出来，
 * 我们只能通过它的静态方法实现对象的创建
 * 一、网络：将不同区域的计算机连接到一起，局域网，城域网，广域网，互联网
 * 二、地址：ip地址 确定网络上 一个绝对地址 | 位置 -->例如现实当中你家的地址
 * 三、端口号：区分计算机软件的 -->像房间号一样 两个字节 2的15次方 -1 0~65535 共65536个
 * 1.在同一个协议下 端口号不能重复 不同协议下可以重复
 * 2.1024以下端口不要使用 80->http 21->ftp
 * 四、资源定位：url:统一资源定位符;uri:统一资源
 * 五、数据传输
 * 1.协议：tcp udp
 * 1）、tcp（transfer control protocol） 电话：三次握手 面向连接 安全可靠 效率较低
 * 2）、udp（userdatagramProtocol）短信 非面向连接 效率高 不可靠
 * 2.传输
 *   1）、先封装
 *   2）、先拆封
 * 相关类：
 *     InetAddress InetSocketAddress       //这是网络层，ip协议应用类
 *     URL  URI                            //这是应用层，http等协议
 *     TCP: ServerSocket Socket            //传输层，建立在网路层之上
 *     UDP: DatagramSocket DatagramPacket  //传输层建立在网络层之上
 *     应用层
 *     表示层           应用层（http或者其他）
 *     会话层
 *     传输层           传输层（tcp/udp）
 *     网络层           网络层（ip）
 *     数据链路层    物理数据链路层
 *     物理层
 * @author gt
 * @created 2016年4月20日 下午3:27:54
 * @since
 */
public class InetAddressTest1 {
      public static void main(String[] args) throws UnknownHostException {
    	//返回本地主机
		InetAddress address = InetAddress.getLocalHost();
		System.out.println(address.getHostAddress());
		System.out.println(address.getHostName());
		System.out.println("================================");
		//根据域名创建inetaddress对象
	    address = InetAddress.getByName("www.baaidu.com");
		System.out.println(address.getHostAddress());
		System.out.println(address.getHostName());
		System.out.println("=================================");
		//根据ip创建inetaddress对象
		address = InetAddress.getByName("52.192.235.160");
		System.out.println(address.getHostAddress());
		System.out.println(address.getHostName());
    }
}
