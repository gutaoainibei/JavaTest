package MYORM.orm.com.gt.sorm.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * 
* @ClassName: ReflectUtils 
* @Description: 反射工具操作类 
* @author gutao 
* @date 2016年10月8日 下午2:22:09 
*
 */
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
    public static void setMethodSetValue(Object object , String columnName,Object objValue){
    	try {
			Class clazz = object.getClass();
			Method method = clazz.getDeclaredMethod("set"+StringUtils.upFirstCharOfString(columnName), objValue.getClass());
			method.invoke(object, objValue);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
    }
}
