package MYORM.orm.com.gt.sorm.utils;
/**
 * 
* @ClassName: StringUtils 
* @Description: 字符串操作工具类 
* @author gutao 
* @date 2016年10月8日 下午2:22:33 
*
 */
public class StringUtils {
	/**
	* @Title: upFirstCharOfString 
	* @Description: 字符串首字母大写 
	* @param @param str
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
    public static String upFirstCharOfString(String str){
    	return str.substring(0, 1).toUpperCase()+str.substring(1);
    }
}
