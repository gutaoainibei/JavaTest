package TestProtectPublic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TestParent <T>{
    private Class clazz; 
	public TestParent() {
		System.out.println("获取当前的this对象："+this);
		System.out.println("获取当前对象的父类对象："+this.getClass().getSuperclass());
		System.out.println("获取当前对象的父类对象的属性(包括泛型)："+this.getClass().getGenericSuperclass());
	    ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
	    clazz = (Class) type.getActualTypeArguments()[0];
     }
     public void test(){
    	 System.out.println(clazz);
     }
}
