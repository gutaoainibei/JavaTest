package roletest1;

public class Cat extends Animal {
	public static void main(String[] args) {
		 /**
		  * 这是Animal的继承
		  * 为了测试private、public、protected权限
		  * private只能本类访问
		  * public是都可以访问
		  * 而protected是只有继承的类(继承类可以直接访问无需创建对象)
		  * 和同一个package的包中可以访问（需要创建对象）
		  */
		   Animal animal = new Animal();
		   System.out.println(animal.default_age);
		   System.out.println(animal.public_name);
		   System.out.println(animal.protected_string);
	}
   
}
