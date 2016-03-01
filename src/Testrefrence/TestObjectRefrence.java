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
		//这里是引用，所以在另外的方法里改了，那么我们此处的值也会改，因为引用所指的是一处物理地址，只有一个对象
		System.out.println("age"+"：为"+map.get("age"));
	}
    public void addAge(Map map){
         map.put("age",20);
    }
}
