package jackSonTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class TestJson {
  public static void main(String[] args) {
	 Account a1 = new Account();
	 Account a2 = new Account();
	 Account a3 = new Account();
	 a1.setId(1);
	 a1.setLogin("1");
	 a1.setName("1");
	 a1.setPass("1111");
	 a2.setId(2);
	 a2.setLogin("2");
	 a2.setName("2");
	 a2.setPass("2222");
	 a3.setId(3);
	 a3.setLogin("3");
	 a3.setName("3");
	 a3.setPass("3333");
	 Category c1 = new Category();
	 Category c2 = new Category();
	 Category c3 = new Category();
	 c1.setAccount(a1);
	 c1.setId(1);
	 c1.setHot(true);
	 c1.setType("sha1");
	 c2.setAccount(a2);
	 c2.setId(2);
	 c2.setHot(true);
	 c2.setType("sha2");
	 c3.setAccount(a3);
	 c3.setId(3);
	 c3.setHot(true);
	 c3.setType("sha3");
	 List<Category> list =new ArrayList<Category>();
	 list.add(c1);
	 list.add(c2);
	 list.add(c3);
	 Map<String,Object> map = new HashMap<String, Object>();
	 map.put("total", 4);
	 map.put("rows", list);
	 ObjectMapper objectMapper = new ObjectMapper();
	 try {
		String json = objectMapper.writeValueAsString(map);
		System.out.println("得到的json:"+json);
	} catch (JsonGenerationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JsonMappingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
