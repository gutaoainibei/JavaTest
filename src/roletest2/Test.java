package roletest2;

import roletest1.Animal;

public class Test {
   public static void main(String[] args) {
	   //这里对权限做一个补充，private只能本类访问
	   //default可以同包中访问，
	   //protected可以不同包但是只能不同包的子类访问，并且拥有上面两个关键字的权限
	   //可以在子类中访问，但是子类如果是不和父类在同一个包中的话，那么通过new一个父类对象
	   //这个对象也是不能访问proted修饰的属性的
	   //public所有包都可以访问
	 Animal animal = new Animal();
	 System.out.println(animal.public_name);
  }
}
