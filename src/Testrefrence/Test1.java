package Testrefrence;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
  public static void main(String[] args) {
	  //""修饰的都属于常量，类的所有信息会被加载在方法区中，new出来的对象会放在堆中指向方法去中对应的
	  //类信息和常量，栈中对应存放的是局部变量，方法区还存放着对应的类的代码信息和静态变量，已经常量池
	String s1 = new String("gutao");
	String s2 = "gutao";//这个数据会放到常量池中，方法区
	System.out.println(s1==s2);
    String s3 = s1;
    System.out.println("方法前："+s1);
    test(s1);
    System.out.println("方法后："+s1);
	System.out.println(s3==s1);
	Map<String,Object> map = new HashMap<String, Object>();
	map.put("name", "gutao");
	map.put("age", 22);
	System.out.println("方法前："+map);
	test(map);
	System.out.println("方法后："+map);
	
   }
   public static void test(String s1){
	   s1 = new String("nibei");
   }
   public static void test(Map map){
	   map.put("name", "nibei");
   }
}
