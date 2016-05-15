package Socket.server;
/**
 * 
 * 描述：实现自己的简单的Servlet
 * @author gt
 * @created 2016年5月13日 下午1:36:07
 * @since
 */
public abstract class Servlet {
     public void service(Request request , Response response){
		    if(request.getMethod().equalsIgnoreCase("get")){
		    	doGet(request, response);
		    }else if (request.getMethod().equalsIgnoreCase("post")) {
				doPost(request, response);
			}
     }
     public abstract void doGet(Request request , Response response);
     
     public abstract void doPost(Request request , Response response);
}
