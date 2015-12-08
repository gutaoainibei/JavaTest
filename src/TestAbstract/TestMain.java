package TestAbstract;

public class TestMain {
    public static void main(String[] args) {
		Animal animal = new Cat();
		Animal animal2 = new Dog();
		animal.breath();
		animal2.breath();
	}
}
