package TestExtends.child2;

import TestExtends.child1.Parent;

public class Children2 extends Parent{
    public static void main(String[] args) {
		Children2 children2 = new Children2();
		System.out.println(children2.age);//prodected 不同包的子类
		System.out.println(children2.shop);//public 
	}
}
