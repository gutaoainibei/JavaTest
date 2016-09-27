package MYORM.orm.com.gt.sorm.utils;

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
	 * ��������������С��λ���ҿ�����������
	 * @author gt
	 * @created 2016��7��20�� ����5:27:42
	 * @since 
	 * @param num С��
	 * @param count ��Ҫ����С����λ��
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
     * ��������ȡ����ʱ��ʱ��
     * @author gt
     * @created 2016��9��1�� ����10:11:01
     * @since 
     * @return
     */
    public static String getToday(){
    	return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
    /**
     * 
     * ��������ȡ���뵱ǰʱ���������������ַ���
     * @author gt
     * @created 2016��9��2�� ����2:13:48
     * @since 
     * @param days ���������˵���Ǻ��죬��������ǰdays��
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
     * ��������ȡ���ظ���id
     * @author gt
     * @created 2016��9��6�� ����4:59:21
     * @since 
     * @return
     */
    public static String getUUID(){
    	return UUID.randomUUID().toString();
    }
    /**
     * 
     * ������
     * @author gt
     * @created 2016��9��7�� ����2:42:36
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
     * �������Ƿ��ǷǸ�ʵ��
     * @author gt
     * @created 2016��9��14�� ����2:48:05
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
    public static void main(String[] args) {
		System.out.println(isNumber("20160-914"));
	}
}
