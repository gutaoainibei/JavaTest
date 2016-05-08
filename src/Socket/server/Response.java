package Socket.server;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;
import TestIO.FileUtils;


/**
 * 
 * 描述：封装相应类
 * @author gt
 * @created 2016年4月29日 下午3:42:12
 * @since
 */
public class Response {
      //回车换行符
	  private static final String CRLF="\r\n";
      //空格
	  private static final String BLANK=" ";
      //头信息
	  private StringBuffer contentHeader;
	  //正文内容
	  private StringBuffer content;
	  
	  //响应流
	  BufferedOutputStream out;
	  private int len = 0;
	  public Response(){
		  content = new StringBuffer();
		  contentHeader = new StringBuffer();
		  len = 0;
	  }
	  
	  public Response(Socket client){
		  this();
		  try {
			out = new BufferedOutputStream(client.getOutputStream());
		} catch (IOException e) {
			contentHeader = null;
			e.printStackTrace();
		}
		
	  }
	  
	  public Response(OutputStream os) throws IOException{
		  this();
		  out = new BufferedOutputStream(os);
	  }
	  /**
	   * 
	   * 描述：相应头创建
	   * @author gt
	   * @created 2016年4月29日 下午4:04:22
	   * @since 
	   * @param code  状态码
	   * @param unicode  编码
	   */
	  private void CreateHeader(int code,String unicode){
		  contentHeader.append("HTTP/1.1").append(BLANK).append(code).append(BLANK);
		  switch (code) {
		     case 200:
		    	 contentHeader.append("gutao success");
			     break;
		     case 404:
		    	 contentHeader.append("NO FOUND");
			     break;
		     case 500:
			      contentHeader.append("SERVER ERROR");
				 break;
		  }
		  contentHeader.append(CRLF);
  	      //2.头信息（Response Head）
		  contentHeader.append("Server:gt Server/1.0.0").append(CRLF);
		  contentHeader.append("Date:").append(new Date()).append(CRLF);
		  contentHeader.append("Content-type:text/html;charset=").append(unicode).append(CRLF);
		  contentHeader.append("Content-Length").append(len).append(CRLF);
		  contentHeader.append(CRLF);
	  }
	  
	  public Response print(String info){
		  content.append(info);
		  len += info.getBytes().length;
		  return this;
	  }
	  public Response println(String info){
		  content.append(CRLF);
		  len += (info+CRLF).getBytes().length;
		  return this;
	  }
	  public void SendResponse(int code,String unicode){
		  if (null == contentHeader) {
			 code = 500;
		  }
		  if(code == 500) {
			  content = new StringBuffer();
			  content.append("SERVER ERROR");
		  }else if (code == 404) {
			  content = new StringBuffer();
			  content.append("NO FOUND");
		  }
		  CreateHeader(code, unicode);
		  try {
			contentHeader.append(content);
			out.write(contentHeader.toString().getBytes());
			out.flush();
			close();
		 } catch (IOException e) {
		 	e.printStackTrace();
		 }
	  }
	  public void SendResponse(int code){
		  SendResponse(code, "utf-8");//默认编码
	  }
	  private void close(){
		  FileUtils.Close(out);
	  }
}
