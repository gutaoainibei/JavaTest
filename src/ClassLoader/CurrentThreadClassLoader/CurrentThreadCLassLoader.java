package ClassLoader.CurrentThreadClassLoader;

import ClassLoader.TestClassLoader.MyClassLoader2;

/**
 * 
 * 描述：创建利用当前线程的类加载器去加载，抛弃传统的双亲委托加载
 * @author gt
 * @created 2016年7月2日 下午11:31:57
 * @since
 */
public class CurrentThreadCLassLoader {
    public static void main(String[] args) throws ClassNotFoundException {
    	//获取当前类的类加载器
		ClassLoader classLoader1 = CurrentThreadCLassLoader.class.getClassLoader();
		System.out.println(classLoader1);
		//获取当前线程上下文的类加载器
        ClassLoader classLoader2 = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader2);
        System.out.println("------------------------");
        Thread.currentThread().setContextClassLoader(new MyClassLoader2("F:/JavaIO"));
        System.out.println(Thread.currentThread().getContextClassLoader());
        Class<?> class1 = Thread.currentThread().getContextClassLoader().loadClass("ClassLoader.test1");
        System.out.println(class1);
        System.out.println(class1.getClassLoader());
        System.out.println("*********************************");
        Thread.currentThread().setContextClassLoader(new MyClassLoader2("F:/JavaIO/com/gt"));
        MyClassLoader2 c1 = (MyClassLoader2) Thread.currentThread().getContextClassLoader();
        System.out.println("当前类加载器："+c1);
        Class<?> class2 = c1.loadClass("People");
        System.out.println(class2);
        System.out.println(class2.getClassLoader());
    }
}
