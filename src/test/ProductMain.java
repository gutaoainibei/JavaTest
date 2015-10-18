package test;

import java.util.HashSet;
import java.util.Set;

public class ProductMain {
   public static void main(String[] args) {
	   ProductTest productTest = new ProductTest();
	   productTest.setName("gutao");
	   productTest.setAge(22);
	   Set<String> addresses = new HashSet<String>();
	   addresses.add("北京");
	   addresses.add("南京");
	   productTest.getAddress().add("北京");
	   productTest.getAddress().add("南京");
	   System.out.println(productTest);
   }
}
