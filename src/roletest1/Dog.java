package roletest1;

public class Dog extends Animal {
	public static void main(String[] args) {
		   Animal animal = new Animal();
		   new Dog().test();
	}
	public void test(){
		 System.out.println(default_age);
		 System.out.println(public_name);
		 System.out.println(protected_string);
	}
}
