package TestString;
/**
 * 
* @ClassName: TestString 
* @Description: TODO(测试字符串类) 
* @author gutao 
* @date 2015年12月11日 下午11:53:02 
*
 */
public class TestString {
	//String 是由final修饰的类，不可继承
  public static void main(String[] args) {
	  char[] c = {1,2,3}; 
	String str = new String(c);
	System.out.println(str);
	String str1 = "asdfs,sdfssdf,dsfas";
	String[] strArray = str1.split(",");
	for (String string : strArray) {
		System.out.println(string);
	}
	String str2 = " sdfa  sdfa ";
	System.out.println(str2.trim());
	System.out.println(str2.trim().replace(" ", ""));
	String strcompare1 = "aaa";
	String strcompare2 = "aaa";
	String stringcompare1 = new String("aaa");
	String stringcompare2 = new String("aaa");
	System.out.println("strcompare1=strcompare2="+strcompare1.equals(strcompare2));
	System.out.println("test1:"+(strcompare1==strcompare2));
	System.out.println("test2:"+(stringcompare1==stringcompare2));
	System.out.println(stringcompare1.equals(stringcompare2));
	System.out.println("test3:"+(stringcompare1==strcompare2));
	
	String g = "asdf";
	g = "qwer";
	System.out.println(g);
	//这里String new了四个对象，分别是"a","b","a+b"以及new的一个s1指向的String对象
	//我们通常知道的final对象是不可以变得，确实是不可变得，但是我们发觉重新赋值好像也可以
	//其实那是重新new了一个对象
	//这里
	String s1 = new String("a"+"b");
	//和上面不一样，这里只有三个对象，"a","b","a+b"
	String s2 = "a"+"b";
    System.out.println(g.startsWith("q"));
    System.out.println(g.endsWith("r"));
    System.out.println(g.equalsIgnoreCase("Qwer"));
}
}
