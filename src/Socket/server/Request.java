package Socket.server;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sun.security.util.Length;


/**
 * 
 * 描述：对用户的请求信息进行封装，方便操作
 * @author gt
 * @created 2016年5月8日 下午7:49:52
 * @since
 */
public class Request {
    //请求方式 
	private String method;
	//请求资源
	private String url;
    //请求参数字符串
	private Map<String, List<String>> parmerStringMap;
	//换行符
	private static final String CRLF = "\r\n";
	//获得的请求字符串
	private String requestString;
	//请求的输入流
	private InputStream in;
	public Request(){
		this.method = "";
		this.requestString = "";
		parmerStringMap = new HashMap<String, List<String>>();
		this.url = "";
	}
	public Request(InputStream in){
		this();
		this.in = in;
		byte[] data = new byte[20480];
		int len = 0;
		try {
			len = in.read(data);
			requestString = new String(data,0,len);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		getParmerString();
	}
	public void getParmerString(){
		if (null==requestString||(requestString=requestString.trim()).equals("")) {
			return;
		} 
		/**
		 * ==================================
		 *      获得请求信息的首行分析出:请求方式   请求地址   请求参数(如果是get方式而且有参数)协议版本
		 *      如 ：GET /index.html?username=%B7%C3%CC%B8&password=dsa HTTP/1.1
		 *      如果是post方式那么请求参数就在请求的正文部分
		 * ==================================
		 */
		//存储参数
		String paramerString = "";
		//获取第一行
		String firstString = requestString.substring(0,requestString.indexOf(CRLF));
		int index = firstString.indexOf("/");
		method = firstString.substring(0,index).trim();
		String urlString = firstString.substring(index, firstString.indexOf("HTTP/")).trim();
		if (method.equalsIgnoreCase("post")) {
			this.url = urlString;//如果是post请求这里就是url不会有参数，参数应该在正文部分，所以这里这样写
		} else if(method.equalsIgnoreCase("get")){
            if(urlString.contains("?")){
            	String[] paramerArray = urlString.split("\\?");
            	this.url = paramerArray[0];
            	paramerString = paramerArray[1];
            }else{
            	this.url = urlString;
            }
		}
	}
	@Override
	public String toString() {
		return "Request [method=" + method + ", url=" + url
				+ ", parmerStringMap=" + parmerStringMap + ", requestString="
				+ requestString + ", in=" + in + "]";
	}
	
}
