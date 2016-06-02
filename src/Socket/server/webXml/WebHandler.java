package Socket.server.webXml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import Socket.server.xml.Person;

public class WebHandler extends DefaultHandler{
	private List<ServlertUrl> servlertList;
	private List<ServletMapping> mappings;
	private String tag;
	private ServletMapping servletMapping;
	private ServlertUrl servlertUrl;
	private boolean isMapping;
	public void startDocument() throws SAXException {
		servlertList = new ArrayList<ServlertUrl>();
		mappings = new ArrayList<ServletMapping>();
	}

	public void endDocument() throws SAXException {
        System.out.println("-------结束文档读取--------");
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		    if (null != qName) {
			  tag = qName;
			  if("servlet".equals(tag)){
				  servlertUrl = new ServlertUrl();
				  isMapping = false;
			  }else if ("servlet-mapping".equals(tag)) {
				  servletMapping = new ServletMapping();
				  isMapping = true;
			  }
		 	}
	}

	public void characters(char ch[], int start, int length)
			throws SAXException {
        String str = new String(ch, start, length);		
        if (isMapping) {
        	 if (null != tag && "servlet-name".equals(tag)) {
        		 servletMapping.setServletName(str);	
			} else if(null != tag && "url-pattern".equals(tag)){
				 servletMapping.getRequestList().add(str);
			}
		} else {
			 if (null != tag && "servlet-name".equals(tag)) {
        		 servlertUrl.setServletName(str);	
			} else if(null != tag && "servlet-class".equals(tag)){
				 servlertUrl.setServlertUrl(str);
			}
		}
	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {
			if ("servlet".equals(qName)) {
				servlertList.add(servlertUrl);
			}else if ("servlet-mapping".equals(qName)) {
				mappings.add(servletMapping);
			}
		    tag = null;
	}
	
	public List<ServlertUrl> getServlertList() {
		return servlertList;
	}

	public void setServlertList(List<ServlertUrl> servlertList) {
		this.servlertList = servlertList;
	}

	public List<ServletMapping> getMappings() {
		return mappings;
	}

	public void setMappings(List<ServletMapping> mappings) {
		this.mappings = mappings;
	}
//	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
//		 //1.获取解析工厂
//		   SAXParserFactory factory = SAXParserFactory.newInstance();
//		   //2.获取解析器
//		   SAXParser saxParser;
//		   //3.关联xml+处理器
//		   WebHandler handler = new WebHandler();
//		   saxParser = factory.newSAXParser();
//		   saxParser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("Socket/server/webXml/web.xml"), handler);
//		   for (ServlertUrl servlertUrl : handler.getServlertList()) {
//			   System.out.println(servlertUrl.getServletName()+"-->"+servlertUrl.getServlertUrl());
//		}
//	}
}
