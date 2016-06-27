package ClassLoader.TestClassLoader;

public class MyTestClassLoader {
	public static void main(String[] args) throws ClassNotFoundException {
		MyClassLoader mycClassLoader = new MyClassLoader("F:/JavaIO");
		Class class1 = mycClassLoader.loadClass("DynamicCompiler");
		System.out.println(class1);
	}
}
