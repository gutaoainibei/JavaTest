package designPattern.Singletons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


/**
 * 
 * 描述：测试单列模式的序列化和反射安全漏洞
 * @author gt
 * @created 2016年7月5日 下午11:11:37
 * @since
 */
public class TestefficiencySignletons {
    public static void main(String[] args) throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException {
		lazySimpleDemo l1 = lazySimpleDemo.getInstances();
		lazySimpleDemo l2 = lazySimpleDemo.getInstances();
		System.out.println(l1);
        System.out.println(l2);
         //通过反射破解单例
//        Class<?> class1 = Class.forName("designPattern.Singletons.lazySimpleDemo");
//        Constructor<?> c = class1.getDeclaredConstructor(null);
//        c.setAccessible(true);
//        lazySimpleDemo llDemo = (lazySimpleDemo) c.newInstance();
//        System.out.println(llDemo);
          //通过反序列化来破解单例
          FileOutputStream fileOutputStream = new FileOutputStream("F:/JavaIO/a.txt");
          ObjectOutputStream ooj = new ObjectOutputStream(fileOutputStream);
          ooj.writeObject(l1);
          ooj.close();
          fileOutputStream.close();
          FileInputStream inputStream = new FileInputStream("F:/JavaIO/a.txt");
          ObjectInputStream input = new ObjectInputStream(inputStream);
          lazySimpleDemo lazySimpleDemo = (designPattern.Singletons.lazySimpleDemo) input.readObject();
          System.out.println(lazySimpleDemo);
	}
}
