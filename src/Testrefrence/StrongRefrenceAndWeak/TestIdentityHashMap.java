package Testrefrence.StrongRefrenceAndWeak;

import java.util.IdentityHashMap;

/**
 * 
 * 描述：测试IdentityHashMap，这个HashMap的key是地址
 * @author gt
 * @created 2016年3月14日 下午4:07:18
 * @since
 */
public class TestIdentityHashMap {
     public static void main(String[] args) {
		IdentityHashMap<String, Object> identityHashMap = new IdentityHashMap<String, Object>();
		identityHashMap.put("name", "gutao");
		identityHashMap.put("name", "nibei");
		System.out.println(identityHashMap.size());
		identityHashMap.put(new String("name"), "luoming");
		identityHashMap.put(new String("name"), "gutaoainibei");
		System.out.println(identityHashMap.size());
	}
}
