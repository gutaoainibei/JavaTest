package TestPolymorphism;


public class TestPolymorphism {
   public void TestPolymorph(ParentAnimal a){
	   //编译的时候不会弄清具体是那个类，只会简单的指向对应的父类，
	   //在程序运行的时候才会具体指向相应的类
	   a.voice();
	   if(a instanceof Cat){
		   ((Cat)a).catchmouse();
	   }
	   if(a instanceof Dog){
		   ((Dog)a).catchhuairen();
	   }
	   if(a instanceof Tiger){
		   ((Tiger)a).catchyang();
	   }
   }
   public static void main(String[] args) {
	   //测试多态
	TestPolymorphism testPolymorphism = new TestPolymorphism();
    ParentAnimal cat = new Cat();
    ParentAnimal dog = new Dog();
    ParentAnimal tiger = new Tiger();
    
	testPolymorphism.TestPolymorph(cat);
	testPolymorphism.TestPolymorph(dog);

	testPolymorphism.TestPolymorph(tiger);

}
}
