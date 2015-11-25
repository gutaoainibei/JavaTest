package Testrefrence;

public class Test1 {
  public static void main(String[] args) {
	  //""修饰的都属于常量，类的所有信息会被加载在方法区中，new出来的对象会放在堆中指向方法去中对应的
	  //类信息和常量，栈中对应存放的是局部变量，方法区还存放着对应的类的代码信息和静态变量，已经常量池
	String s1 = "gutao";
	String s2 = "gutao";
	System.out.println(s1==s2);
}
}
