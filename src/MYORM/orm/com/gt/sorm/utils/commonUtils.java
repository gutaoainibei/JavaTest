package MYORM.orm.com.gt.sorm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
* @ClassName: commonUtils 
* @Description: 通用工具类
* @author gutao 
* @date 2016年10月8日 下午2:19:43 
*
 */
public class commonUtils {
	/**
		* @Title: getDoubleRound 
		* @Description: 四舍五入数字 
		* @param @param 需要操作的数字
		* @param @param 精确到几位
		* @param @return    设定文件 
		* @return double    返回类型 
		* @throws
	 */
    public static double getDoubleRound(Double num,int count){
    	double number = num;
    	number = number*Math.pow(10,count);
    	number = Math.round(number);
    	number = number/100;
    	return number;
    }
   /**
	   * @Title: getToday 
	   * @Description: 获取当前时间（yyyy-MM-dd HH:mm:ss格式） 
	   * @param @return    设定文件 
	   * @return String    返回当前时间
	   * @throws
    */
    public static String getToday(){
    	return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
    /**
	    * @Title: getTodayRecentDay 
	    * @Description: 获取当前时间的近几天的时间 
	    * @param @param 需要的格式
	    * @param @param 近几天，如果是0就是当天
	    * @param @return    设定文件 
	    * @return String    返回类型 
	    * @throws
     */
    public static String getTodayRecentDay(String format,int days){
    	Calendar calendar = Calendar.getInstance();
    	calendar.add(Calendar.DAY_OF_MONTH, days);
    	Date date = calendar.getTime();
    	String dataStr = new SimpleDateFormat(format).format(date);
    	return dataStr;
    }
   /**
	   * @Title: getUUID 
	   * @Description: 获取UUID
	   * @param @return    设定文件 
	   * @return String    返回类型 
	   * @throws
    */
    public static String getUUID(){
    	return UUID.randomUUID().toString();
    }
    /**
	    * @Title: compareDate 
	    * @Description: 比较时间 
	    * @param @param begintime
	    * @param @param endtime
	    * @param @param format
	    * @param @return    设定文件 
	    * @return boolean    返回类型 
	    * @throws
     */
    public static boolean compareDate(String begintime,String endtime,String format){
    	try {
			Date beginTime = new SimpleDateFormat(format).parse(begintime);
			Date endTime = new SimpleDateFormat(format).parse(endtime);
			Date now = new SimpleDateFormat(format).parse(new SimpleDateFormat(format).format(new Date()));
			long bTime = beginTime.getTime();
			long eTime = endTime.getTime();
			long nTime = now.getTime();
			if(nTime >= bTime && nTime <= eTime){
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		} 
    	return false;
    }
   /**
	   * @Title: isNumber 
	   * @Description: 判断是否是非负实数 
	   * @param @param param
	   * @param @return    设定文件 
	   * @return boolean    返回类型 
	   * @throws
    */
    public static boolean isNumber(String param){
    	boolean flag = false;
    	Pattern pattern = Pattern.compile("^\\d*\\.{0,1}\\d+$");
    	Matcher matcher = pattern.matcher(param);
    	flag = matcher.matches();
    	return flag;
    }
}
