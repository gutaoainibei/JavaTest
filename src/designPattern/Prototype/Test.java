package designPattern.Prototype;

public class Test {
   public static void main(String[] args) {
	System.out.println(System.getProperty("java.class.path"));
	System.out.println(System.getProperty("user.dir"));
	System.out.println(Test.class.getClassLoader().getResource(""));
    
   }
}
