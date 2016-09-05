package InnerClass;

import InnerClass.StaticInnerClasss.gt;
import InnerClass.StaticInnerClasss.test1;

/**
 * 
 * 描述：静态内部类测试
 * @author gt
 * @created 2016年7月3日 下午10:17:49
 * @since
 */
public class StaticInnerClasss {
    private String name;
    private static int age;
    public static class test1{
    	int price;
    	public void te(){
    		//静态内部类可以直接访问外部类的静态方法
    		test();
    		//静态内部类可以直接访问外部类的静态属性
    		System.out.println(age);
    	}
    }
    public static void test(){
    	class gtainibei{
    	
    	}
    }
    public void gutao(){
    	int ag;
    	//方法内部类不能定义静态成员属性
    	//static String name;
    	class nibei{
    		int gg;
    		void gutaoainibei(){
    			//方法内部类只在方法中有效，而且不能访问方法的成员变量，
    			//只能访问final修饰的编译时可以确定的常量表达式，new Date()就无法识别
    			//System.out.println(ag);
    		}
    		Test test = new Test() {
				//方法匿名内部类
				public void run() {
					
				}
			};
    	}
    }
    //成员内部类，这个是个对象绑定的
    public class gt{
    	void test(){
    		
    	}
    }
    //类名内部类
    Test test = new Test() {
		
		public void run() {
			System.out.println(name);
			System.out.println(age);
		}
	};
}
interface Test{
	public void run();
}
class Demo{
	public static void main(String[] args) {
		//静态内部类可以直接访问
		test1 t = new test1();
        //成员内部类是绑定在对象上的
		gt g = new StaticInnerClasss().new gt();
	}
}