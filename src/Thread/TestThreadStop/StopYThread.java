package Thread.TestThreadStop;
/**
 * 描述： 
 * 
 *      1.新生状态
 *      2.就绪状态
 *      3.运动状态
 *      4.就绪状态
 *      5.死亡状态
 *      停止线程
 *      推荐方式：1、自然终止线程正常执行完毕
 *              2、外部干涉
 *              1).线程类中定义线程体使用标识
 *              2).线程体使用该标识
 *              3).提供对外的方法改变该标识
 *              4).外部根据条件调用该方法即可
 * @author gt
 * @created 2016年4月12日 下午9:28:10
 * @since
 */
public class StopYThread {
    public static void main(String[] args) {
		ThreadRunnable t1 = new ThreadRunnable();
		Thread thread = new Thread(t1);
		thread.start();
		for (int i = 0; i < 100; i++) {
			if(i==30){
			   t1.setFlag(false);
			}
			System.out.println("main........"+i);
		}
	}
}
class ThreadRunnable implements Runnable{
    private boolean flag = true;
    private int i =0;
	@Override
	public void run() {
		while (flag) {
			System.out.println("run Thread......"+(i++));
		}
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
