package TestExtends.child1;

public class Other1 {
   public static void main(String[] args) {
	 Parent parent = new Parent();
	 System.out.println(parent.address);//default
	 System.out.println(parent.shop);//public
	 System.out.println(parent.age);//protected 同包
}
}
