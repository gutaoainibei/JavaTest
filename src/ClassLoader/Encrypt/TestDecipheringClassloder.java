package ClassLoader.Encrypt;

import java.io.File;

import ClassLoader.TestClassLoader.MyClassLoader;

/**
 * 
 * 描述：测试加密
 * @author gt
 * @created 2016年6月30日 下午11:35:52
 * @since
 */
public class TestDecipheringClassloder {
      public static void main(String[] args) throws ClassNotFoundException {
//		EncryptUtil.Encrypt(new File("F:/JavaIO/DynamicCompiler1.class"), new File("F:/DynamicCompiler1.class"));
//        MyClassLoader classLoader = new MyClassLoader("F:");
//  	    Class<?> class0 = classLoader.loadClass("DynamicCompiler1");
//  	    System.out.println(class0);
    	DecipheringClassLoader classLoader1 = new DecipheringClassLoader("F:");
	    Class<?> class1 = classLoader1.loadClass("DynamicCompiler1");
	    System.out.println(class1);
      }
}
