package Reflection.TestJavassist;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.Modifier;
import javassist.NotFoundException;
/**
 * 
 * 描述：想在编译时不存在运行时动态创建并加载，通常有两种做法
 *      1.动态编译
 *      2.动态生成二进制字节码（.class）,现在比较成熟的项目提供支持，
 *        BCEL(Byte Code Engineering Library):这是Apache Software Foundation
 *        的Jakarta项目的一部分，BCEL与Java classworking广泛使用的一种框架，它可以让您
 *        深入JVM汇编语言进行类操作的细节，BCEL与Javassist有不同的处理字节码的方法，BCEL
 *        在实际的JVM指令层次上进行操作（BCEL）拥有丰富的JVM指令集支持而Javassist的所强调
 *        的是源代码级别的工作
 *        ASM:是一个轻量级的java字节码操作框架，直接涉及到JVM底层的操作和指令
 *        CGLIB（Code Generation Library）:一个强大的，高性能，高质量的Code生成类库，基于ASM实现
 *        Javassist:是一个开源的分析，编辑和创建Java字节码的类库，性能较ASM差，跟CGLIB差不多，但是使用简单
 *        很多开源框架都在使用它
 *        
 *        测试开源框架Javassist生成字节码文件，实现静态语言的动态性
 *        动态的生成字节码文件
 * @author gt
 * @created 2016年6月21日 下午3:30:41
 * @since
 */
public class TestJavassist {
     public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
    	 InsertClassCode();
     }
     
     public static void InsertClassCode(){
    	 ClassPool classPool = ClassPool.getDefault();
    	 try {
			CtClass ctClass = classPool.get("Reflection.TestJavassist.User");
			CtMethod ctMethod = ctClass.getDeclaredMethod("test", null);
			ctMethod.insertBefore("System.out.println(\"gt insert before\");");
			ctMethod.insertAfter("System.out.println(\"gt insert after\");");
			ctMethod.insertAt(44, "System.out.println(\"gt insert linenumber\");");
			Class class1 = ctClass.toClass();
            Object object = class1.newInstance();
            Method method = class1.getDeclaredMethod("test", null);
            method.setAccessible(true);
            method.invoke(object, null);
    	 } catch (NotFoundException e) {
			e.printStackTrace();
		} catch (CannotCompileException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
     }
     /**
      * 
      * 描述：动态的向指定的java类中添加方法，实现java语言的动态性
      * @author gt
      * @created 2016年6月22日 下午5:30:03
      * @since
      */
     public static void TestChangeClassArchitecture(){
    	 ClassPool classPool = ClassPool.getDefault();
    	 try {
			CtClass ctClass = classPool.get("Reflection.TestJavassist.User");
			//向指定的类new一个新方法
			CtMethod ctNewMethod = CtNewMethod.make("public void test(){System.out.println(1111);}", ctClass);
			//向ctClass对象（可以看作是一个字节码对象）添加一个方法
			ctClass.addMethod(ctNewMethod);
			//将CtClass对象转换成Class对象
			Class class1 = ctClass.toClass();
			Object object = class1.newInstance();
			Method method = class1.getDeclaredMethod("test",null);
			method.invoke(object, null);
		} catch (NotFoundException e) {
			e.printStackTrace();
		} catch (CannotCompileException e) {
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
		} catch (InstantiationException e) {
			e.printStackTrace();
		} 
     }
     /**
      * 
      * 描述：处理类的基本用法
      * @author gt
      * @created 2016年6月22日 下午4:23:29
      * @since
      */
     public static void TestClassCode(){
    	 ClassPool classPool = ClassPool.getDefault();
    	 try {
    		//获得指定的类的CtClass对象
			CtClass ctclass = classPool.get("Reflection.TestJavassist.User");
			//把CtClass类对象转换成字节数组
			byte[] arrays = ctclass.toBytecode();
			System.out.println(Arrays.toString(arrays));
			//打印出包名
			System.out.println("包名："+ctclass.getPackageName());
			//打印全类名
			System.out.println("全类名："+ctclass.getName());
			//打印类名
			System.out.println("类名："+ctclass.getSimpleName());
		} catch (NotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CannotCompileException e) {
			e.printStackTrace();
		} 
     }
     /**
      * 
      * 描述：动态生成字节码文件
      *      我们通过动态编译同样也可以做这样的一件事情
      *      我们可以写好对应的代码写到.java文件中让后进行动态编译
      * @author gt
      * @created 2016年6月22日 上午9:54:22
      * @since 
      * @throws CannotCompileException
      * @throws NotFoundException
      * @throws IOException
      */
     public static void productClassFile()throws CannotCompileException, NotFoundException, IOException {
    	//1.获取类池
 	    ClassPool classPool = ClassPool.getDefault();
 	    //2.指定要创建的类
 	    CtClass ctClass = classPool.makeClass("com.gt.Person");
 	    //new属性的第一种方式
 	    CtField field1 = new CtField(classPool.get("java.lang.String"), "name", ctClass);
 	    field1.setModifiers(Modifier.PRIVATE);
 	    ctClass.addField(field1);
 	    //添加属性对应的set和get方法
 	    setAndget(ctClass, field1);
 	    //new属性的第二种方式
         CtField field2 = CtField.make("private int age;", ctClass);
         ctClass.addField(field2);
         setAndget(ctClass, field2);
         //new方法的第一种方式
         CtMethod method1 = new CtMethod(classPool.get("java.lang.String"),"getString",new CtClass[]{classPool.get("java.lang.String"),CtClass.intType},ctClass);
         //设置方法体
         method1.setBody("return $1+$2;");
         //设置方法的访问范围（private ，public等等）
         method1.setModifiers(Modifier.PUBLIC);
         //向类中添加方法
         ctClass.addMethod(method1);
         //new方法的第二种方式
         CtMethod method2 = CtMethod.make("public void printlnString(){System.out.println(\"gutao test javassist\");}", ctClass);
         //向类中添加方法
         ctClass.addMethod(method2);
         //new含餐构造函数
         CtConstructor constructor = new CtConstructor(new CtClass[]{classPool.get("java.lang.String"),CtClass.intType}, ctClass);
         constructor.setModifiers(Modifier.PUBLIC);
         constructor.setBody("{this.name = $1;this.age = $2;}");
         ctClass.addConstructor(constructor);
         CtConstructor noParamconstructor = new CtConstructor(null, ctClass);
         ctClass.addConstructor(noParamconstructor);
         constructor.setBody("{this;}");
         //指定位置生成字节码文件
         ctClass.writeFile("F:/JavaIO");
         System.out.println("生成类成功");
     }
     public static void setAndget(CtClass ctClass,CtField field){
    	try {
			ctClass.addMethod(CtNewMethod.setter("set"+field.getName(), field));
		    ctClass.addMethod(CtNewMethod.getter("get"+field.getName(), field));
		} catch (CannotCompileException e) {
			e.printStackTrace();
		}
     }
}
