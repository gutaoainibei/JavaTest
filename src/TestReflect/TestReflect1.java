package TestReflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

public class TestReflect1 {
  public static void main(String[] args) {
	  try {
		Class c = Class.forName("TestReflect.TestReflect");
		 Field[] field = c.getDeclaredFields();
		 Method[] methods = c.getDeclaredMethods(); 
		 StringBuffer stringBuffer = new StringBuffer();
		 stringBuffer.append(Modifier.toString(c.getModifiers()) + " class " + c.getSimpleName() +"{\n");
		 for (Field fl : field) {
			stringBuffer.append("\t");
			stringBuffer.append(Modifier.toString(fl.getModifiers()) + " ");
			stringBuffer.append(fl.getType().getSimpleName()+" ");
			stringBuffer.append(fl.getName()+";\n");
		    
		 }
		 for (Method method : methods) {
			stringBuffer.append(Modifier.toString(method.getModifiers())+" ");
			stringBuffer.append(method.getReturnType().getSimpleName()+" ");
			stringBuffer.append(method.getName()+"(){}\n");

		}
		stringBuffer.append("}");
		System.out.println("反射之后得到的："+stringBuffer);
	  } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
  }
}
