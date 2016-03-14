package Testrefrence.StrongRefrenceAndWeak;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/**
 * 
 * 描述：java中的弱连接，这个只针对对象，对常量是没有任何意义的
 * @author gt
 * @created 2016年3月14日 下午3:36:42
 * @since
 */
public class TestStrongRefrences {
    public static void main(String[] args) {
		String string = "gutao.com";
		String string2 = new String("nibei.com");

		WeakReference<String> weakReference = new WeakReference<String>(string);
		Person person = new Person();
		person.setAddress("江苏省淮安市");
		person.setAge(23);
		person.setName("gutao");
		WeakReference<Person> weakReference2 = new WeakReference<Person>(person);
		WeakReference<String> weakReference3 = new WeakReference<String>(string2);

		System.out.println("gc运行前："+weakReference.get());
		System.out.println("gc运行前："+weakReference2.get());
		System.out.println("gc运行前："+weakReference3.get());
		System.out.println("======================================");
		string = null;
		person = null;
		string2 = null;
		//此时refrence断了但是我们的内存里面的对象还没有回收
		System.gc();
		System.runFinalization();
		System.out.println("gc运行后："+weakReference.get());
		System.out.println("gc运行后："+weakReference2.get());
		System.out.println("gc运行后："+weakReference3.get());
	}
}
