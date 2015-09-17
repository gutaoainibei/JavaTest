package roletest1;

import com.sun.javafx.geom.AreaOp.AddOp;

public class ProTest {
    public static void main(String[] args) {
		ProTest proTest = new ProTest();
		 Animal animal1 = new Animal();
		 Animal animal2 = new Animal();
		 Animal.gt++;
		 //proTest.test();
		System.out.println(animal1.gt);
		System.out.println(animal2.gt);
	    animal1.gt++;
		System.out.println(animal1.gt);
		System.out.println(animal2.gt);
		
	}
    public void test(){
    	 Animal animal = new Animal();
    	 System.out.println(animal.default_age);
		 System.out.println(animal.public_name);
		 System.out.println(animal.protected_string);
    }
    public void add(){
    	Animal.gt++;
    }
    public void add1(){
    	Animal.gt++;
    }
}
