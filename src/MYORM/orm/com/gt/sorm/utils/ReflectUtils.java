package MYORM.orm.com.gt.sorm.utils;

import java.lang.reflect.Method;

@SuppressWarnings("all")
public class ReflectUtils {
	/**
	 * 
	 * 描述：通过反射返回指定对象的方法的返回值
	 * @author gt
	 * @created 2016年9月26日 下午5:37:45
	 * @since 
	 * @param object
	 * @param primaryKey
	 * @return
	 */
    public static Object getMethodRetunValue(Object object,String primaryKey){
    	try {
			Class clazz = object.getClass();
			Method method = clazz.getDeclaredMethod("get"+StringUtils.upFirstCharOfString(primaryKey), null);
			return method.invoke(object, null);
		} catch (Exception e) {
			return null;
		} 
    }
}
