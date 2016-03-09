package TestNet.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
public class HttpRequest {
	private final static Logger logger = Logger.getLogger(HttpRequest.class);
	public static String sendGet(String url, Map params) {
		String resultString = "";
		String urlString = url;
		BufferedReader bufferedReader = null;
		Set set = params.entrySet();
		Iterator<Map.Entry<String, Object>> iterator = set.iterator();
		StringBuffer stringBuffer = new StringBuffer();
		while (iterator.hasNext()) {
			Map.Entry<String, Object> object = iterator.next();
			String key = object.getKey();
			String value = (String) object.getValue();
			stringBuffer.append(key + "=" + value + "&");
		}
		String paramsString = new String();
		if(stringBuffer.length()>0){
		   paramsString = stringBuffer.substring(0,
				stringBuffer.length() - 1);
		   urlString = "?" + paramsString;
		}
		logger.info("请求的数据地址："+urlString);
		try {
			URL realUrl = new URL(urlString);
			String encode = new String(); 
			URLConnection urlConnection = realUrl.openConnection();
//			urlConnection.setRequestProperty("accept", "/");
//			urlConnection.setRequestProperty("connection", "Keep-Alive");
			urlConnection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//			urlConnection.setRequestProperty("Accept-Charset", "UTF-8");
			urlConnection.connect();
			Map<String, List<String>> map = urlConnection.getHeaderFields();
			for(String key : map.keySet()){
				logger.info(key + "--->" + map.get(key));
			}
			//如果想防止乱码问题，在读取输入流的时候就加上编码设置
			bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
			String inStr = null;  
//            String reg = "meta http-equiv=\"Content-Type\" content=\".*?charset=(.*?)\"";  
//            Pattern p = Pattern.compile(reg);  
//              
//            while ((inStr = bufferedReader.readLine()) != null) {  
//                Matcher m = p.matcher(inStr);  
//                if(m.find()){  
//                    encode = m.group(1);  
//                    logger.debug("code:" + encode);  
//                    break;  
//                }  
//            }  
//			System.out.println("encode:"+encode);
			String line = new String();
			while(bufferedReader!=null&&bufferedReader.readLine()!=null){
				line = bufferedReader.readLine();
				resultString += line;
			}
		
		} catch (MalformedURLException e) {
			 System.out.println("发送GET请求出现异常！" + e);  
			 e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {  
            try {  
                if (bufferedReader != null) {  
                	bufferedReader.close();  
                }  
            } catch (Exception e2) {  
                e2.printStackTrace();  
            }  
        }  
		logger.info("获取到的数据："+resultString);
		return resultString;
	}
	public static String sendPost() {
		return "";
	}

	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "gutao");
//		map.put("pwd", "1111");
		sendGet("http://localhost:8080/MyTestWeb/index.xml", map);
	}
}
