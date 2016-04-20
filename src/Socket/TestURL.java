package Socket;

import java.net.MalformedURLException;
import java.net.URL;

public class TestURL {
    public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://www.baidu.com:80/index.html?username=gutao");
		System.out.println("协议："+url.getProtocol());
		System.out.println("域名："+url.getHost());
		System.out.println("端口："+url.getPort());
		System.out.println("资源："+url.getFile());
		System.out.println("相对路径："+url.getPath());
		System.out.println("锚点："+url.getRef());
		System.out.println("参数："+url.getQuery());//如果存在锚点，参数也会被当作是锚点
		url = new URL("http://www.baidu.com:80/index");//没有斜杆，下面的就是http://www.baidu.com:80/gt.txt
		url = new URL(url, "gt.txt");//前面为父路径
		System.out.println(url.toString());
	}
}
