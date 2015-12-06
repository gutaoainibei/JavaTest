package roletest2;

import roletest1.Animal;

public class ExtendAnimal extends Animal{
	public void test(){
		System.out.println(protected_string);
		Animal animal = new Animal();
		System.out.println(animal.public_name);
	}
    public static void main(String[] args) {
		Animal animal = new Animal();
		System.out.println(animal.public_name);
	}
}
