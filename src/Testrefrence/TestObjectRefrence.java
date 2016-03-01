package Testrefrence;

import java.util.HashMap;
import java.util.Map;

public class TestObjectRefrence {
    public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "gutao");
		map.put("age", 22);
		TestObjectRefrence obj = new TestObjectRefrence();
		obj.addAge(map);
		System.out.println("age"+"：为"+map.get("age"));
	}
    public void addAge(Map map){
         map.put("age",20);
    }
}
