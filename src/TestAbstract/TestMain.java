package TestAbstract;

public class TestMain {
    public static void main(String[] args) {
    	//抽象类是不可以实例化的，但是他可以指向继承类的实例对象
    	//抽象类是为了定下一种规范，我们必须按照我们设计好的模板来，继承他的类必须实现他的抽象方法
    	//他也可以定义普通的方法和构造器，但是他的构造器是被子类调用的，自己调用不了，以为自己没法实例化
    	//有抽象方法的类都叫抽象类，抽象类只用来继承
    	//定义为那个类型那么在编译时只能调用定义它的那个类中的方法和变量或者常量，他的实列化对象中的方法和属性是调用不了的
    	//除非强转
		Animal animal = new Cat();
		Animal animal2 = new Dog();
		animal.breath();
		animal2.breath();
	}
}
