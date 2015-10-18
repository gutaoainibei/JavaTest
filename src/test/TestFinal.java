package test;

public class TestFinal {
	 public static void main(String[] args)  {

	        String a = "hello2";  

	        final String b = "hello";

	        String d = "hello";
	        
	        d = d + "1";

	        String c = b + 2;  

	        String e = d + 2;
   
	        System.out.println(c);
	        System.out.println(e); 
	        System.out.println(d);
	        
	        System.out.println((a == c));

	        System.out.println((a == e));

	    }
}
