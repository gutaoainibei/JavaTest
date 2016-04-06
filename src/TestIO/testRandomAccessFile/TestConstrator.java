package TestIO.testRandomAccessFile;
/**
 * 
 * 描述：测试构造函数以及继承关系，构造函数的调用顺序问题
 *     先调用父类的无参构造函数，在调用自己的构造函数
 * @author gt
 * @created 2016年4月7日 上午12:07:00
 * @since
 */
public class TestConstrator extends gutao{
	 String name;
	 String age;
     public TestConstrator(){
    	 age = new String();
    	 System.out.println("=====");
     }
     public TestConstrator(String name){
    	 this(name, "21");
    	 System.out.println("name");
     }
     public TestConstrator(String name,String age){
    	 this();
    	 this.name = name ;
    	 this.age = age;
    	 System.out.println("name and age");
     }
     public static void main(String[] args) {
		TestConstrator t1 = new TestConstrator("gutao", "23");
		System.out.println("----------------------------------");
		TestConstrator t2 = new TestConstrator("nibei");

	}
}
class gutao{
	public gutao(){
		System.out.println("gutao");
	}
	public gutao(String name){
		System.out.println("nibei");
	}
}