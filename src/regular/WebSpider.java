package regular;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * 描述：网络爬虫简单测试
 * @author gt
 * @created 2016年8月2日 下午10:57:07
 * @since
 */
public class WebSpider {
   public static void main(String[] args) {
	
	 String str = WebSpider.getStringOfPage("http://www.duba.com", "utf-8");
	 List<String> list = getUrls("href=\"([\\w\\s./:]+?)\"", str);
	 for (String string : list) {
		System.out.println(string);
	}
   }
   /**
    * 
    * 描述：
    * @author gt
    * @created 2016年8月2日 下午11:35:15
    * @since 
    * @param regularExpression正则表达式
    * @param destStr目标过滤字符串
    * @return
    */
   public static List<String> getUrls(String regularExpression,String destStr){
	   List<String> list = new ArrayList<String>();
	   Pattern pattern = Pattern.compile(regularExpression);
		 Matcher matcher = pattern.matcher(destStr);
		 while (matcher.find()) {
			list.add(matcher.group(1));
		}
	   return list;
   }
   /**
    * 
    * 描述：获取页面代码
    * @author gt
    * @created 2016年8月2日 下午11:29:41
    * @since 
    * @param urlString 需要爬的页面url
    * @param unicode 需要按什么编码格式进行爬虫
    * @return
    */
   public static String getStringOfPage(String urlString , String unicode){
	     StringBuffer str = new StringBuffer();
		 try {
			URL url = new URL(urlString);
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(),Charset.forName(unicode)));
		    String temp = "";
		    while ((temp = reader.readLine()) != null) {
			     str.append(temp+"\n");
			}
		 } catch (MalformedURLException e) {
		 	e.printStackTrace();
		 } catch (IOException e) {
			e.printStackTrace();
		 }
	   return str.toString();
   }
}
