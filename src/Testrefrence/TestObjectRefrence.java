package Testrefrence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestObjectRefrence {
    public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "gutao");
		map.put("age", 22);
		TestObjectRefrence obj = new TestObjectRefrence();
		obj.addAge(map);
		//这里是引用，所以在另外的方法里改了，那么我们此处的值也会改，因为引用所指的是一处物理地址，只有一个对象
		System.out.println("age"+"：为"+map.get("age"));
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		list.add(map);
		obj.changeListOfMap(list);
		System.out.println(list.get(0).get("age"));
		System.out.println(map.get("age"));
	}
    public void addAge(Map map){
         map.put("age",20);
    }
    public void changeListOfMap(List list) {
		Map<String, Object> map = (Map<String, Object>) list.get(0);
		map.put("age", 25);
	}
}
