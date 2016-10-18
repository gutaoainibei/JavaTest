package common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class commonUtils {
	/**
	 * 
	 * ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ð¡ï¿½ï¿½Î»ï¿½ï¿½ï¿½Ò¿ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
	 * @author gt
	 * @created 2016ï¿½ï¿½7ï¿½ï¿½20ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½5:27:42
	 * @since 
	 * @param num Ð¡ï¿½ï¿½
	 * @param count ï¿½ï¿½Òªï¿½ï¿½ï¿½ï¿½Ð¡ï¿½ï¿½ï¿½ï¿½Î»ï¿½ï¿½
	 * @return
	 */
    public static double getDoubleRound(Double num,int count){
    	double number = num;
    	number = number*Math.pow(10,count);
    	number = Math.round(number);
    	number = number/100;
    	return number;
    }
    /**
     * 
     * ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½È¡ï¿½ï¿½ï¿½ï¿½Ê±ï¿½ï¿½Ê±ï¿½ï¿½
     * @author gt
     * @created 2016ï¿½ï¿½9ï¿½ï¿½1ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½10:11:01
     * @since 
     * @return
     */
    public static String getToday(){
    	return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
    /**
     * 
     * ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½È¡ï¿½ï¿½ï¿½ëµ±Ç°Ê±ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ö·ï¿½ï¿½ï¿½
     * @author gt
     * @created 2016ï¿½ï¿½9ï¿½ï¿½2ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½2:13:48
     * @since 
     * @param days ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ëµï¿½ï¿½ï¿½Çºï¿½ï¿½ì£¬ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ç°daysï¿½ï¿½
     * @return
     */
    public static String getTodayRecentDay(String format,int days){
    	Calendar calendar = Calendar.getInstance();
    	calendar.add(Calendar.DAY_OF_MONTH, days);
    	Date date = calendar.getTime();
    	String dataStr = new SimpleDateFormat(format).format(date);
    	return dataStr;
    }
    /**
     * 
     * ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½È¡ï¿½ï¿½ï¿½Ø¸ï¿½ï¿½ï¿½id
     * @author gt
     * @created 2016ï¿½ï¿½9ï¿½ï¿½6ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½4:59:21
     * @since 
     * @return
     */
    public static String getUUID(){
    	return UUID.randomUUID().toString();
    }
    /**
     * 
     * ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
     * @author gt
     * @created 2016ï¿½ï¿½9ï¿½ï¿½7ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½2:42:36
     * @since 
     * @return
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
     * 
     * ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ç·ï¿½ï¿½Ç·Ç¸ï¿½Êµï¿½ï¿½
     * @author gt
     * @created 2016ï¿½ï¿½9ï¿½ï¿½14ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½2:48:05
     * @since 
     * @param param
     * @return
     */
    public static boolean isNumber(String param){
    	boolean flag = false;
    	Pattern pattern = Pattern.compile("^\\d*\\.{0,1}\\d+$");
    	Matcher matcher = pattern.matcher(param);
    	flag = matcher.matches();
    	return flag;
    }
    /**
     * 
     * ÃèÊö£ºÅÐ¶Ï×Ö·û´®ÊÇ·ñÎª¿Õ
     * @author gt
     * @created 2016Äê10ÔÂ18ÈÕ ÉÏÎç11:17:58
     * @since 
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str){
		return (str == null || str.trim().length()<1) ? false : true;
	}
	/**
	 * 
	 * ÃèÊö£ºÅÐ¶ÏÊý×éÊÇ·ñÎª¿Õ
	 * @author gt
	 * @created 2016Äê10ÔÂ18ÈÕ ÉÏÎç11:18:31
	 * @since 
	 * @param objs
	 * @return
	 */
	public static boolean isNotEmpty(Object[] objs){
		return (objs == null || objs.length < 1) ? false : true;
	}
    public static void main(String[] args) {
		System.out.println(isNumber("20160-914"));
	}
}
