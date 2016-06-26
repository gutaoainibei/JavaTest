package ClassLoader.TestSortLoader;


/**
 * 
 * 描述：测试java的类加载顺序
 *     这个测试类主要是为了测试类的加载顺序，或者说初始化的顺序
 *     类在运行过程中只会被加载一次
 * @author gt
 * @created 2016年6月23日 下午1:45:32
 * @since
 */
public class TestClassLoaderSort extends ParentLoader{
	static{
		System.out.println("2.初始化类TestClassLoaderSort");
	}
	public static void main(String[] args) {
		System.out.println("3.开始测试加载顺序");
		//到这里是不会加载Child类的，因为加载final静态常量是不会初始化类的
		System.out.println(Child.width);
		//Child的height属性是静态成员（除了final修饰以外）和静态方法都会初始化类，所以这里会初始化Child，
		System.out.println(Child.height);
//      Father.testStatic();
//		Child.say();
//		System.out.println(Father.size);
//		Child child1 = new Child();
//		Child child2 = new Child();
//		//这里主要是为了测试Father在加载后还会不会被加载
//		Father father = new Father();
//		System.out.println(father.getClass());
//		System.out.println(Child.height);
	}
}
class ParentLoader{
	static{
		System.out.println("1.初始化类ParentLoader");
	}
}
class Child extends Father{
	public static int height = 40;
	public static final int width = 100;
	static{
		height = 400;
		System.out.println("5.初始化Child");
	}
	public Child(){
		System.out.println("6.new一个Child对象");
	}
	public static void say(){
		System.out.println("gutao"); 
	}
}
class Father{
	public String name;
	public static final int size = 100;
	static{
		System.out.println("4.初始化Father");
	}
	public static void testStatic(){
		System.out.println("class Father testStatic");
	}
}