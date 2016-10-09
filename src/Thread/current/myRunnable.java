package Thread.current;
/**
* @ClassName: myRunnable 
* @Description: 自己记得线程类
* @author gutao 
* @date 2016年10月9日 下午3:16:19 
 */
public class myRunnable implements Runnable{

	private String taskName;
	public myRunnable() {
	}
	public myRunnable(String taskName){
		this.taskName = taskName;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			 System.out.println("当前线程:"+taskName+"  正在执行");		
		}
	}
}
