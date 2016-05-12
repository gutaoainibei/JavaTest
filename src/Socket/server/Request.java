package Socket.server;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import oracle.net.aso.s;

import com.mysql.fabric.xmlrpc.base.Array;
import com.sun.crypto.provider.RSACipher;

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
	private void getParmerString(){
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
		    paramerString = requestString.substring(requestString.lastIndexOf(CRLF)).trim();
		} else if(method.equalsIgnoreCase("get")){
            if(urlString.contains("?")){//这里url的全称，/index.html?name=gutao&age=21
            	String[] paramerArray = urlString.split("\\?");
            	this.url = paramerArray[0];//获取到？前面的url:/index.html
            	paramerString = paramerArray[1];//获取到传到后台的参数:name=gutao&age=21
            }else{
            	this.url = urlString;
            }
		}
		if (paramerString.equals("")) {
			return ;
		}
		initParamerValues(paramerString);
	}
	/**
	 * 
	 * 描述：初始化请求参数格式，变成Map格式
	 * @author gt
	 * @created 2016年5月12日 下午3:43:36
	 * @since 
	 * @param paramerString
	 */
	private void initParamerValues(String paramerString){
		StringTokenizer stringTokenizer = new StringTokenizer(paramerString,"&");
		while(stringTokenizer.hasMoreTokens()){
			String keyvalue = stringTokenizer.nextToken();
			String[] keyvalues = keyvalue.split("=");
			if(keyvalues.length == 1){//这里考虑如果没有传值过来怎么办
				keyvalues = Arrays.copyOf(keyvalues, 2);
			}
			String key = keyvalues[0].trim();
			String value = null == keyvalues[1] ? null : keyvalues[1].trim();//判断值是否为空
			if (!parmerStringMap.containsKey(key)) {
				parmerStringMap.put(key, new ArrayList<String>());
			} 
			List<String> valuesList = parmerStringMap.get(key);
			valuesList.add(value);
		}
	}
	/**
	 * 
	 * 描述：获取一个key有多个值的传参，如复选框
	 * @author gt
	 * @created 2016年5月12日 下午3:44:44
	 * @since 
	 * @param name
	 * @return
	 */
	public String[] getParamerValues(String name){
		  List<String> values = parmerStringMap.get(name);
		  if (null == values) {
			 return null;
		} else {
             return values.toArray(new String[0]);
		}
	}
	/**
	 * 
	 * 描述：获取单个值
	 * @author gt
	 * @created 2016年5月12日 下午3:45:17
	 * @since 
	 * @param name
	 * @return
	 */
	public String getParamerValue(String name){
		String[] values = getParamerValues(name);
		if(values == null){
			return null;
		}else {
			return values[0];
		}
	}
	/**
	 * 
	 * 描述：获取用户的url
	 * @author gt
	 * @created 2016年5月12日 下午3:49:01
	 * @since 
	 * @return
	 */
	public String getUrl() {
		return url;
	}
}
