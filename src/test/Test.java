package test;

import java.lang.reflect.Method;
import java.lang.reflect.Field;

import roletest2.ProTest;




public class Test {
  public static void main(String[] args) {
	  Class an = ProTest.class;
	  /**
	   * 获得类的所有公共方法
	   * **/
	  Method[] meth = an.getMethods();
	  for (Method m : meth) {
		String method_name = m.getName();
		System.out.println("方法名："+method_name);
	  }
	  /**
	   * 获取类的你自己声明public的属性
	   * **/
	  System.out.println("---------分界线-----------");
	  Field fileds[] = an.getFields();
	  for (Field filed : fileds) {
		  String filed_name = filed.toString();
		  System.out.println("属性名："+filed_name);
	  }
	  System.out.println("---------分界线-----------");
	  /**
	   * 获得类的所有方法(自己声明的，包含私有方法)
	   * **/
	  Method[] meth1 = an.getDeclaredMethods();
	  for (Method m : meth1) {
		String method_name = m.getName();
		System.out.println("方法名11111："+method_name);
	  }
	  System.out.println("---------分界线-----------");
	  /**
	   * 获得类的所有属性(含私有属性)
	   * **/
	  Field filed1[] = an.getDeclaredFields();
	  for (Field filed : filed1) {
		  String filed_name = filed.toString();
		  System.out.println("属性名111111："+filed_name);
	  }  
  }
  
  
}
