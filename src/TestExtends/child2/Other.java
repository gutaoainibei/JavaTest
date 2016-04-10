package TestExtends.child2;

import TestExtends.child1.Parent;

public class Other {
   public static void main(String[] args) {
	 Parent parent = new Parent();
	 System.out.println(parent.shop);//public不同包
}
}
