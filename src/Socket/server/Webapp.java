package Socket.server;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import Socket.server.webXml.ServlertUrl;
import Socket.server.webXml.ServletMapping;
import Socket.server.webXml.WebHandler;

public class Webapp {
   public static ServletContext servletContext;
   static{
	   servletContext = new ServletContext();
	   //1.获取解析工厂
	   SAXParserFactory factory = SAXParserFactory.newInstance();
	   //2.获取解析器
	   SAXParser saxParser;
	   //3.关联xml+处理器
	   WebHandler handler = new WebHandler();
	   try {
		saxParser = factory.newSAXParser();
		saxParser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("Socket/server/webXml/web.xml"), handler);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	   Map<String, String> servletUrl = servletContext.getServlet();
	   for (ServlertUrl servlert : handler.getServlertList()) {
		   System.out.println("url:"+servlert.getServlertUrl());
		  servletUrl.put(servlert.getServletName(), servlert.getServlertUrl());
	   }
	   Map<String, String> mapping = servletContext.getMapping();
	   for (ServletMapping servletMapping : handler.getMappings()) {
		   
		   List<String> requestList = servletMapping.getRequestList();
		   for (String string : requestList) {
			   System.out.println("reuqest:"+string);
			   mapping.put(string, servletMapping.getServletName());
		   }
	   }
   }
   public static Servlet getServlet(String url) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
	   if(null ==url || url.trim().equals("")){
	       return null;  
	   }
	   String className =  servletContext.getServlet().get(servletContext.getMapping().get(url));
	   System.out.println("全类名："+className);
	   return (Servlet)Class.forName(className).newInstance();

   }
}
