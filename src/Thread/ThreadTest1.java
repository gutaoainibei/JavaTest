package Thread;
/**
 * 
 * 描述：run()要通过start()来启动，start()方法只是把线程启动
 * 但是启动不意味着运行
 * @author gt
 * @created 2016年4月11日 下午3:26:50
 * @since
 */
public class ThreadTest1 implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("gutao ai nibei");

		}
	}
   public static void main(String[] args) {
	ThreadTest1 test1 = new ThreadTest1();
	Thread thread = new Thread(test1);
	thread.start();
	for (int i = 10; i > 0; i--) {
		System.out.println("倒计时"+i);
	}

}
}
