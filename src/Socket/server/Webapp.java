package Socket.server;

import java.util.Map;

public class Webapp {
   public static ServletContext servletContext;
   static{
	   servletContext = new ServletContext();
	   Map<String, Servlet> servlet = servletContext.getServlet();
	   servlet.put("login", new loginServlet());
	   servlet.put("register", new registerServlet());
	   Map<String, String> mapping = servletContext.getMapping();
	   mapping.put("/login", "login");
	   mapping.put("/reg", "register");
   }
   public static Servlet getServlet(String url){
	   if(null ==url || url.trim().equals("")){
	       return null;  
	   }
	   return servletContext.getServlet().get(servletContext.getMapping().get(url));

   }
}
