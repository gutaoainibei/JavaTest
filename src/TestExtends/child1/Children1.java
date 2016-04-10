package TestExtends.child1;

public class Children1 extends Parent{
    public static void main(String[] args) {
		Children1 children1 = new Children1();
		System.out.println(children1.address);//default 同包的子类
		System.out.println(children1.age);//protected
		System.out.println(children1.shop);//public
	}
}
