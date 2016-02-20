package Testrefrence;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 
 * 描述：用来检测关于对象引用的问题
 * @author gt
 * @created 2016年2月19日 下午11:35:30
 * @since
 */
public class UnderStand {
   public static void main(String[] args) {
	   Set set = new HashSet();
	   set.add("gutao");
	   set.add("nibei");
	   set.add("luoming");
	   Iterator iterator = set.iterator();
	   while (iterator.hasNext()) {
		 String keyString  = (String)iterator.next();
		 System.out.println(keyString);
		
	    }
//	String[] s1 = {"1","2","3"};
//	String[] s2 = s1;
//	s2[2]="gutao";
//	for (String string : s2) {
//		System.out.println(string);
//	}
//	for (String string : s1) {
//		System.out.println(string);
//	}
}
}
