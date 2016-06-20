package Reflection.demo01;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class TestGenericClass implements GenericTest<String> {
   public void testGeneric01(Map<String, Object> map,List<String> list){
	   System.out.println("测试反射获取泛型");
   }
   public Map<Integer, User> testGeneric02(){
	   System.out.println("测试反手获得返回类型");
	   return null;
   }
   public static void main(String[] args) throws InstantiationException, IllegalAccessException {
	   try {
		Type[] ts =TestGenericClass.class.getGenericInterfaces();
		for (Type type : ts) {
			System.out.println("#"+type);
			//获取实际类型参数
			Type[] types = ((ParameterizedType)type).getActualTypeArguments();
			for (Type intype : types) {
				Class class1 = (Class)intype;
				//这里intype是个type类型
				System.out.println(intype.getClass().getSimpleName());
				//class1才是对象Class模板对象，这里要弄清楚Type和Class的关系和区别
				System.out.println(class1.getSimpleName());
			}
		}
		Method method = TestGenericClass.class.getDeclaredMethod("testGeneric01", Map.class,List.class);
	    Type[] types = method.getGenericParameterTypes();
	    for (Type type : types) {
			System.out.println("#"+type);
			if (type instanceof ParameterizedType) {
				Type[] genericTypes = ((ParameterizedType) type).getActualTypeArguments();
			    for (Type genericType : genericTypes) {
				  System.out.println("泛型类型："+genericType);
			    }
			}
		}
	    System.out.println("-----------------------------------------------");
	    //获得指定方法返回的泛型信息
	    Method method2 = TestGenericClass.class.getDeclaredMethod("testGeneric02", null);
	    Type returnType = method2.getGenericReturnType();
	    if (returnType instanceof ParameterizedType) {
			Type[] reTypes = ((ParameterizedType)returnType).getActualTypeArguments(); 
		    for (Type type : reTypes) {
				System.out.println("返回的，泛型类型"+type);
			}
	    }
	   } catch (SecurityException e) {
		e.printStackTrace();
	} catch (NoSuchMethodException e) {
		e.printStackTrace();
	}
}
}
interface GenericTest<T>{
	
}