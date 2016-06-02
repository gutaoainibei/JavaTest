package Socket.server.xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.events.StartDocument;

import oracle.net.aso.q;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PersonHandler extends DefaultHandler {
	private List<Person> persons;
	private Person person;
	private String tag;
	public void startDocument() throws SAXException {
		persons = new ArrayList<Person>();
	}

	public void endDocument() throws SAXException {
        System.out.println("-------结束文档读取--------");
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		    if (null != qName) {
			  tag = qName;
			  if("person".equals(tag)){
				  person = new Person();
			  }
		 	}
	}
    
	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public void characters(char ch[], int start, int length)
			throws SAXException {
        String str = new String(ch, start, length);		
        if (null != str && "name".equals(tag)) {
			person.setName(str);
		}else if (null !=str && "age".equals(tag)) {
			Integer age = Integer.parseInt(str);
			person.setAge(age);
		}
	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if ("person".equals(qName)) {
			persons.add(person);
		}
		tag = null;
	}
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//1.获取解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//2.获取解析器
		SAXParser saxParser = factory.newSAXParser();
		//3.指定xml+处理器
		PersonHandler handler = new PersonHandler();
		saxParser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("Socket/server/xml/webtest.xml"), handler);
	    List<Person> persons = handler.getPersons();
	    for (Person person : persons) {
			System.out.println(person.getName()+"-->"+person.getAge());
		}
	    
	}
}
