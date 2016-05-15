package Socket.server;

public class registerServlet extends Servlet{

	@Override
	public void doGet(Request request, Response response) {
		  doPost(request, response);
	}

	@Override
	public void doPost(Request request, Response response) {
		 System.out.println("注册");
		 response.print("注册成功！");
	}

}
