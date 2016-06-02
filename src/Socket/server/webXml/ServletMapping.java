package Socket.server.webXml;

import java.util.ArrayList;
import java.util.List;

public class ServletMapping {
	private String servletName;
	private List<String> requestList;

	
	public ServletMapping(){
		requestList = new ArrayList<String>();
	}
	public String getServletName() {
		return servletName;
	}

	public void setServletName(String servletName) {
		this.servletName = servletName;
	}

	public List<String> getRequestList() {
		return requestList;
	}

	public void setRequestList(List<String> requestList) {
		this.requestList = requestList;
	}

}
