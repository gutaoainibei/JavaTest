package Reflection.TestJavassist;

import java.awt.Dialog.ModalityType;
import java.io.IOException;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.IntType;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
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
 * @author gt
 * @created 2016年6月21日 下午3:30:41
 * @since
 */
public class TestJavassist {
     public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
    	//1.获取类池
	    ClassPool classPool = ClassPool.getDefault();
	    //2.指定要创建的类
	    CtClass ctClass = classPool.makeClass("com.gt.Person");
	    //new属性的第一种方式
	    CtField field1 = new CtField(classPool.get("java.lang.String"), "name", ctClass);
	    field1.setModifiers(Modifier.PRIVATE);
	    setAndget(ctClass, field1);
	    //new属性的第二种方式
        CtField field2 = CtField.make("private int age;", ctClass);
        setAndget(ctClass, field2);
        //new方法的第一种方式
        CtMethod method1 = new CtMethod(classPool.get("java.lang.String"),"getString",new CtClass[]{classPool.get("java.lang.String"),CtClass.intType},ctClass);
        method1.setBody("return $1+$2;");
        method1.setModifiers(Modifier.PUBLIC);
        //new方法的第二种方式
        CtMethod method2 = CtMethod.make("public void printlnString(){System.out.println(\"gutao test javassist\");}", ctClass);
        ctClass.writeFile("F:/JavaIO");
        System.out.println("生成类成功");
     }
     public static void setAndget(CtClass ctClass,CtField field1){
    	try {
			ctClass.addMethod(CtNewMethod.setter("setName", field1));
		    ctClass.addMethod(CtNewMethod.getter("getName", field1));
		} catch (CannotCompileException e) {
			e.printStackTrace();
		}
     }
}
