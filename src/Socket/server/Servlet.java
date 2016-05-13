package Socket.server;
/**
 * 
 * 描述：实现自己的简单的Servlet
 * @author gt
 * @created 2016年5月13日 下午1:36:07
 * @since
 */
public class Servlet {
     public void service(Request request , Response response){
		    System.out.println(request.getUrl());
		    StringBuffer responseContext = new StringBuffer();
		    responseContext.append("欢迎:"+request.getParamerValue("name"));
		    response.print(responseContext.toString());
     }
}
