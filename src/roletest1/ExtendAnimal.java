package roletest1;

public class ExtendAnimal extends Animal {
	public void test(){
		Animal animal = new Animal();

	}
    public static void main(String[] args) {
    	Animal animal = new Animal();
    	System.out.println(animal.protected_string);
    	System.out.println(animal.default_age);
    	System.out.println(animal.public_name);
	}
}
