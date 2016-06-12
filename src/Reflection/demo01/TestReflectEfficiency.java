package Reflection.demo01;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 
 * 描述：测试反射效率
 * @author gt
 * @created 2016年6月12日 下午5:06:31
 * @since
 */
public class TestReflectEfficiency {
	//1.普通方法的效率
    public static void test01(){
    	User user = new User();
    	long startTime = System.currentTimeMillis();
    	for (int i = 0; i < 1000000000L; i++) {
			user.getName();
		}
    	long endTime = System.currentTimeMillis();
    	System.out.println("普通方法调用了10亿次，用时："+(endTime-startTime)+"ms");
    }
    //2.反射调用方法的效率
    public static void test02() throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
    	User user = new User();
    	Class clazz = user.getClass();
    	Method method = clazz.getDeclaredMethod("getName", null);
    	long startTime = System.currentTimeMillis();
    	for (int i = 0; i < 1000000000L; i++) {
    		method.invoke(user, null);
		}
    	long endTime = System.currentTimeMillis();
    	System.out.println("反射方法调用了10亿次，用时："+(endTime-startTime)+"ms");
    }
    //3.反射不做安全检测的效率
    public static void test03() throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
    	User user = new User();
    	Class clazz = user.getClass();
    	Method method = clazz.getDeclaredMethod("getName", null);
    	method.setAccessible(true);
    	long startTime = System.currentTimeMillis();
    	for (int i = 0; i < 1000000000L; i++) {
    		method.invoke(user, null);
		}
    	long endTime = System.currentTimeMillis();
    	System.out.println("取消安全检测反射方法调用了10亿次，用时："+(endTime-startTime)+"ms");
    }
    public static void main(String[] args) throws SecurityException, IllegalArgumentException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
//		test01();
//		test02();
//		test03();
	}
}
