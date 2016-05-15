package Socket.server;

public class loginServlet extends Servlet{

	@Override
	public void doGet(Request request, Response response) {
		doPost(request, response);
	}

	@Override
	public void doPost(Request request, Response response) {
		String name = request.getParamerValue("name");
		String password = request.getParamerValue("password");
		if(checkPwd(name, password)){
			response.print("登录成功");
		}else{
			response.print("密码或用户名错误");
		}
	}
    public boolean checkPwd(String name, String password){
    	return ("gutao".equals(name)&&"1111".equals(password));
    }
}
