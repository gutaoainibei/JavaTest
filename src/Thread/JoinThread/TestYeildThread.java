package Thread.JoinThread;
/**
 * 
 * 描述：线程阻塞
 *      1.join
 *      2.yield暂停自己的线程 static,写在那个线程体里面就暂停那个线程提
 * @author gt
 * @created 2016年4月12日 下午10:10:40
 * @since
 */
public class TestYeildThread {
     public static void main(String[] args) throws InterruptedException {
    	ThreadRunnaleYeild t1 = new ThreadRunnaleYeild();
		Thread thread = new Thread(t1);
		thread.start();
		for (int i = 0; i < 1000; i++) {
			if (i%20==0) {
				Thread.yield();//thread线程暂停
			}
			System.out.println("main......."+i);
		}
	}
}
class ThreadRunnaleYeild implements Runnable{
	private int i = 0;
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("yeild in thread ........"+(i));
		}
	}
	
}