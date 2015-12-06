package roletest2;

import roletest1.Animal;

public class ExtendAnimal extends Animal{
	public void test(){
		//这里可以看出之前说的子类中可以访问父类的protectted修饰的属性
	    //在不同包中不能访问protected修饰和子类中可以访问取交集,子类可以访问，但是自己new一个父类是不允许访问的因为不同包
		System.out.println(protected_string);
		protectedname();
		Animal animal = new Animal();
		System.out.println(animal.public_name);
	}
    public static void main(String[] args) {
		Animal animal = new Animal();
		animal.publicname();
		System.out.println(animal.public_name);
	}
}
