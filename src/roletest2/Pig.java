package roletest2;


import roletest1.Animal;

public class Pig extends Animal {
	public static void main(String[] args) {		 
		   Pig pig = new Pig();
		   Animal animal = new Animal(); 
		   System.out.println(animal.public_name);
		   pig.test();
		
	}
	public void test(){
		 System.out.println(public_name);
		 System.out.println(protected_string);

	}
}
