package Socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;


/**
 * 
 * 描述：下载网页
 * @author gt
 * @created 2016年4月20日 下午5:47:55
 * @since
 */
public class TestUrlResources {
     public static void main(String[] args) throws UnsupportedEncodingException, IOException {
    	  testUrlbyReader();
     }
     public static void testSystemout() throws IOException{
    	 URL url = new URL("http://www.baidu.com/index.html");
    	 InputStream in = url.openStream();
    	 int len = 0;
    	 byte[] flush = new byte[1024];
    	 while(-1!=(len = in.read(flush))){
    		 System.out.println(new String(flush,0,len));
    	 }
     }
     /**
      * 
      * 描述：通过InputStream和OutputStream来读写数据
      * @author gt
      * @created 2016年4月21日 上午9:42:18
      * @since 
      * @throws IOException
      */
     public static void testUrlbyStream() throws IOException{
    	 URL url = new URL("http://www.baidu.com/index.html");
 		//这里只能读取文字
 		BufferedInputStream inputStream = new BufferedInputStream(url.openStream());
 		BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("F:/baidu.html"));
 		byte[] flush = new byte[1024]; 
 		int len = 0;
 		while (-1 != (len = inputStream.read(flush))) {
 			    outputStream.write(flush, 0, len);
 		}
 		outputStream.flush();
 		inputStream.close();
 	    outputStream.close();
     }
     /**
      * 
      * 描述：通过Reader和Writer来读写数据
      * @author gt
      * @created 2016年4月21日 上午9:41:49
      * @since 
      * @throws UnsupportedEncodingException
      * @throws IOException
      */
     public static void testUrlbyReader() throws UnsupportedEncodingException, IOException{
    	 URL url = new URL("http://www.baidu.com");
 		//这里只能读取文字
 		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
 		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("F:/baidu.html"),"utf-8"));
 		String msg = null;
 		while (null != (msg = reader.readLine())) {
 			   writer.append(msg);
 			   writer.newLine();
 		}
 		writer.flush();
 		reader.close();
 	    writer.close();
     }
}
