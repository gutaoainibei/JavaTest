package Thread.Task;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 * 描述：定时任务
 * @author gt
 * @created 2016年4月19日 上午9:59:22
 * @since
 */
public class TestTimer {
    public static void main(String[] args) {
    	TestTimerTask task = new TestTimerTask();
		Timer timer = new Timer();
		timer.schedule(task, 0, 3000);
	
	}
}
class TestTimerTask extends TimerTask{
	@Override
	public void run() {
		System.out.println("gutao");
	}
	
}
