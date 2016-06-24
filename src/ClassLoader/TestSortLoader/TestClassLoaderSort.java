package ClassLoader.TestSortLoader;


/**
 * 
 * 描述：测试java的类加载顺序
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
        Father.testStatic();
		Child.say();
		System.out.println(Father.size);
		Child child1 = new Child();
		Child child2 = new Child();
		Father father = new Father();
		System.out.println(father.getClass());
		System.out.println(Child.height);
	}
}
class ParentLoader{
	static{
		System.out.println("1.初始化类ParentLoader");
	}
}
class Child extends Father{
	public static int height = 40;
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