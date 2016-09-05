package Thread.JoinThread;
/**
 * 
 * 描述：线程阻塞
 *      1.join
 *      2.yield暂停自己的线程 static
 * @author gt
 * @created 2016年4月12日 下午10:10:40
 * @since
 */
public class TestJoinThread {
     public static void main(String[] args) throws InterruptedException {
		ThreadRunnaleJoin t1 = new ThreadRunnaleJoin();
		Thread thread = new Thread(t1);
		thread.start();
		for (int i = 0; i < 100; i++) {
			if (i == 40) {
				thread.join();//合并线程，main阻塞，可以理解为插队
			}
			System.out.println("main.......");
		}
	}
}
class ThreadRunnaleJoin implements Runnable{
	private int i = 0;
	public void run() {
		for (int i = 0; i < 30; i++) {
			System.out.println("join in thread ........"+(i));
		}
	}
	
}