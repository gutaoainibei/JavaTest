package Reflection.demo01;

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
	Invocable invocable = (Invocable)engine;
}
}
