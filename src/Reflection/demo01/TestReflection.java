package Reflection.demo01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@SuppressWarnings("all")
public class TestReflection {
   public static void main(String[] args) {
	  String path = "Reflection.demo01.User";
	  try {
		//反射得出Class的封装对象
		Class clazz = Class.forName(path);
		//1.new一个对象
		User user = (User)clazz.newInstance();
		//2.获取所有的公共属性
		Field[] fields = clazz.getFields();
		System.out.println("类的公共属性个数："+fields.length);
		System.out.println("-------------------------");
		//3.获取所有的属性
		fields = clazz.getDeclaredFields();
		System.out.println("所有属性个数："+fields.length);
		for (Field field : fields) {
			System.out.println(field);
		}
		Field field = clazz.getDeclaredField("id");
		//这个属性不再进行安全检查
		field.setAccessible(true);
		field.set(user, "01");
		System.out.println(user.getId());
		System.out.println("-------------------------");
		//4.获取类的方法
		Method[] methods = clazz.getDeclaredMethods();
		System.out.println("类的所有方法个数："+methods.length);
		for (Method method : methods) {
			System.out.println(method);
		}
		//这里可以动态获取方法
		Method m1 = clazz.getDeclaredMethod("getName", null);
		
		System.out.println(m1);
		Method m2 = clazz.getDeclaredMethod("setName", String.class);
		//激活方法，初始化数据
		m2.invoke(user, "gutao");
		System.out.println(m2);
		System.out.println(user.getName());
		System.out.println("----------------------------------------");
		//获取构造函数
		Constructor[] constructors = clazz.getDeclaredConstructors();
		for (Constructor constructor : constructors) {
			System.out.println(constructor);
		}
		//调用空构造器
		//Constructor c1 = clazz.getConstructor(null);
		//System.out.println(c1);
		//调用含参构造器
		Constructor<User> c1 = clazz.getConstructor(String.class,String.class,String.class);
		User u1 = c1.newInstance("1001","gutao","江苏");
		System.out.println(u1.getName());
	} catch (ClassNotFoundException e) {
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
	} catch (NoSuchFieldException e) {
		e.printStackTrace();
	}
}
}
