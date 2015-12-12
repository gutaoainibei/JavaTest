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
	System.out.println(strcompare1==strcompare2);
	System.out.println(stringcompare1==stringcompare2);
	System.out.println(stringcompare1.equals(stringcompare2));
	System.out.println(stringcompare1==strcompare2);

}
}
