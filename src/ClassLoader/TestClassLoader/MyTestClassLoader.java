package ClassLoader.TestClassLoader;

public class MyTestClassLoader {
	public static void main(String[] args) throws ClassNotFoundException {
		MyClassLoader mycClassLoader1 = new MyClassLoader("F:/JavaIO");
		MyClassLoader mycClassLoader2 = new MyClassLoader("F:/JavaIO");

		Class<?> class1 = mycClassLoader1.loadClass("DynamicCompiler1");
		Class<?> class2 = mycClassLoader1.loadClass("DynamicCompiler1");
		Class<?> class3 = mycClassLoader2.loadClass("DynamicCompiler1");
		Class<?> class4 = mycClassLoader1.loadClass("java.lang.String");
		System.out.println(class1.hashCode());
		System.out.println(class2.hashCode());
		//被两个不同的类加载器加载同一个类，JVM不认为是相同类
		System.out.println(class3.hashCode());
		//自定义类加载器才加载得到
		System.out.println(class3.getClassLoader());
		//父类加载器就可以加载到了
		System.out.println(class4.getClassLoader());
		System.out.println(System.getProperty("user.dir"));
		
	}
}
