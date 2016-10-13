package test;

import java.util.ArrayList;
import java.util.List;

public class TestFinal {
	 static final List<Integer> gt = new ArrayList<Integer>();
	 public static void main(String[] args)  {
	        String a = "hello2";  
	        final String b = "hello";
	        String d = "hello";
	        String c = b + 2;  
	        String e = d + 2;
	        System.out.println(c);
	        System.out.println(e); 
	        System.out.println(d);
	        System.out.println((a == c));
	        System.out.println((a == e));
	        System.out.println("------------------------");
	        gt.add(10);
            System.out.println(gt);
            gt.add(100);
            System.out.println(gt);
	    }
}
