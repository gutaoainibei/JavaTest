package Socket.server;

import java.util.Map;

public class Webapp {
   public static ServletContext servletContext;
   static{
	   servletContext = new ServletContext();
	   Map<String, String> servletUrl = servletContext.getServlet();
	   servletUrl.put("login", "Socket.server.loginServlet");
	   servletUrl.put("register", "Socket.server.registerServlet");
	   Map<String, String> mapping = servletContext.getMapping();
	   mapping.put("/login", "login");
	   mapping.put("/reg", "register");
   }
   public static Servlet getServlet(String url) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
	   if(null ==url || url.trim().equals("")){
	       return null;  
	   }
	   String className =  servletContext.getServlet().get(servletContext.getMapping().get(url));
	   return (Servlet)Class.forName(className).newInstance();

   }
}
