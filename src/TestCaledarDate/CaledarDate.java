package TestCaledarDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CaledarDate {
     public static void main(String[] args) {
    	System.out.println("请输入年月日（格式如2012-11-11）：");
    
    	Scanner scanner =new Scanner(System.in);
	    String str = scanner.nextLine();
	    //大写的M表示月，小写的m表示分钟
	    DateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
	    int days = 0;
	    int day = 0;
	    Calendar calendar = null;
	    try {
			Date date = formate.parse(str);
			calendar = new GregorianCalendar();
			calendar.setTime(date);;
			//获取当前输入时间的天数（一个月中）
            day = calendar.get(Calendar.DATE);
            //设置为当前月的第一天
            calendar.set(Calendar.DATE,1);
            //获得第一天是星期几
			System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
			//获得最大天数
			System.out.println(calendar.getActualMaximum(Calendar.DATE));
			
			days = calendar.getActualMaximum(Calendar.DATE);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("日\t一\t二\t三\t四\t五\t六");
    	for(int j=1 ;j<calendar.get(Calendar.DAY_OF_WEEK); j++){
			System.out.print("\t");
		}
		for(int i = 1 ;i<=days ;i++){
			if(day == i){
				System.out.print("*");
			}
			System.out.print(i+"\t");
			int dayweek = calendar.get(Calendar.DAY_OF_WEEK);
			if(dayweek==Calendar.SATURDAY){
				System.out.print("\n");
			}
			calendar.add(Calendar.DATE, 1);
		}
		
	 }
}
