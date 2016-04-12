package Thread.TestSleep;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * 描述：倒计时
 * @author gt
 * @created 2016年4月12日 下午10:49:59
 * @since
 */
public class SleepDemo01 {
   public static void main(String[] args) throws InterruptedException {
    Date endtime = new Date(System.currentTimeMillis()+10*1000);
    long end = endtime.getTime();
    DateFormat dateFormat = new SimpleDateFormat("mm:ss");		
    while (true) {
	   System.out.println(dateFormat.format(endtime));
	   endtime = new Date(endtime.getTime()-1000);
	   Thread.sleep(1000);
	   if(10000 < (end - endtime.getTime())){
		   break;
	   }
	}
	
}
}

