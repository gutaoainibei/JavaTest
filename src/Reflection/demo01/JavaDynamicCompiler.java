package Reflection.demo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;



/**
 * JDK6.0引入动态编译机制
 * 描述：测试动态编译
 * @author gt
 * @created 2016年6月14日 下午11:15:35
 * @since
 */
public class JavaDynamicCompiler {
   public static void main(String[] args) {
	//1.获取java编译工具对象
	JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
	//2.指定编译文件，可以是一个或者多个，第一个参数表示输入参数，第二个参数表示输出参数，第三个是错误输出，第四个是错误信息流
	int result = javaCompiler.run(null, null, null, "F:/JavaIO/DynamicCompiler.java","F:/JavaIO/DynamicCompiler1.java");
	System.out.println(result==0?"编译成功":"编译失败");
	//获取一个新的进程运行
	Runtime runtime = Runtime.getRuntime();
	//初始化进程类
	Process process = null;
	String msg = ""; 
	try {
		//ClassPath:资源路径，className：类名
		//  java -cp ClassPath className
		process = runtime.exec("java -cp "+"F:/JavaIO/"+" DynamicCompiler");
		//获取进程输出流
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		while ((msg=reader.readLine())!=null) {
			System.out.println(msg);
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
	//获取当前的项目的绝对根路径
	System.out.println(JavaDynamicCompiler.class.getResource("/"));
	System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
	//通过反射来运行编译好的类，这后面的斜杠是必须加的
	String dir = "F:/JavaIO/";
	try {
		//1.资源路径
		URL[] urls = new URL[]{new URL("file:/"+dir)};
		//2.获取资源类加载器
		URLClassLoader urlClassLoader = new URLClassLoader(urls);
		//3.加载指定的类到模板Class
		Class class1 = urlClassLoader.loadClass("DynamicCompiler");
		//通过反射获取到指定的类
		Method method = class1.getDeclaredMethod("main", String[].class);
		//这里必须加上（Object）强转，不然就会被认为是可变参数是多个参数，而不是一个参数类型为数组的参数
		//可变参数是JDK5才加的新特性
		method.invoke(null, (Object)new String[]{});
		
	} catch (MalformedURLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SecurityException e) {
		e.printStackTrace();
	} catch (NoSuchMethodException e) {
		e.printStackTrace();
	} catch (IllegalArgumentException e) {
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		e.printStackTrace();
	}
}
}
