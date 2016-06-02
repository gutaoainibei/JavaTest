package Socket.server;

import java.io.IOException;
import java.net.Socket;

/**
 * 
 * 描述：自己实现的转发器
 * @author gt
 * @created 2016年5月13日 下午6:03:46
 * @since
 */
public class Dispatcher implements Runnable{
	//客户请求的管道
    private Socket client;
    //客户端请求封装实例
    private Request request;
    //客户端响应请求实例
    private Response response;
    //相应码，就是我们前台得到的200，404，500之类的
    private int code;
    public Dispatcher(Socket client){
    	this.client = client;
    	try {
			this.request = new Request(client.getInputStream());
			this.response = new Response(client.getOutputStream());
			code = 200;
		} catch (IOException e) {
			try {
				client.close();
				code = 500;
				return ;
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
    }
	@Override
	public void run() {
		Servlet servlet = null;
		try {
			System.out.println("请求地址"+request.getUrl());
			servlet = Webapp.getServlet(request.getUrl());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (servlet == null) {
			code = 404;
		} else {
			servlet.service(request, response);
		}
		response.SendResponse(code);
	}

}
