package Reflection.demo01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 从jdk6开始引入，新特性
 * 描述：测试java脚本引擎
 * @author gt
 * @created 2016年6月20日 下午5:17:57
 * @since
 */
public class TestJavaScriptEngine {
   public static void main(String[] args) {
	//获取脚本引擎管理器
	ScriptEngineManager engineManager = new ScriptEngineManager();
	//指定脚本语言
	ScriptEngine engine = engineManager.getEngineByName("javascript");
	//操作数据
	engine.put("msg", "gutao");
    String str = "var person={name:'nibei',age:23,address:'江苏'};";
	try {
		str += "println(person.name);";
		engine.eval(str);
		//动态语言特性，在我们运行时还可以改变对应的值
		engine.eval("msg = 'nibei'");
		System.out.println(engine.get("msg"));
	} catch (ScriptException e) {
		e.printStackTrace();
	}
	try {
		//java调用js函数
		//立马执行脚本
		engine.eval("function add(a,b){var sum = a + b ;return sum;}");
		//转化为Invocable对象，调用函数
		Invocable invocable = (Invocable)engine;
		//这里的new Object[]{3,4}相当于传（3，4）
		Object object = invocable.invokeFunction("add", new Object[]{3,4});
		System.out.println(object);
		//js调用java函数
		String javaCode = "importPackage(java.util);var list = Arrays.asList([\"顾涛\",\"帆哥\",\"乐乐\"]);";
	    engine.eval(javaCode);
	    List<String> list = (List<String>)engine.get("list");
	    for (String string : list) {
			System.out.println("js调用java函数："+string);
		}
	    //调用外部的js文件，指定我们的文件绝对路径
	    URL filepath = TestJavaScriptEngine.class.getResource("/Reflection/javaScript.js"); 
//	    System.out.println(filepath);
	    //新建源文件
	    File file = new File(filepath.getPath());
	    //增强管道字符读入
	    BufferedReader reader = new BufferedReader(new FileReader(file));
	    engine.eval(reader);
	} catch (ScriptException e) {
		e.printStackTrace();
	} catch (NoSuchMethodException e) {
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
