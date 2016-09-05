package Thread.TestSleep;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * 
 * 描述：测试多线程共享一个资源这样可能会出问题
 * 如果不对资源进行同步保护
 * @author gt
 * @created 2016年4月14日 下午11:38:23
 * @since
 */
public class TestThreadSyn12306 {
   public static void main(String[] args) throws InterruptedException, ExecutionException {
	    TicketThread t1 = new TicketThread();
	    Thread thread1 = new Thread(t1, "顾涛");
	    Thread thread2 = new Thread(t1, "倪贝");
	    Thread thread3 = new Thread(t1, "罗明");
	    thread1.start();
	    thread2.start();
	    thread3.start();
	  // TestCall();
   }
   public static void TestCall() throws InterruptedException, ExecutionException{
	   ExecutorService e1 = Executors.newFixedThreadPool(3);
		Ticket t1 = new Ticket();
		Future<Integer> future1 = e1.submit(t1);
		Future<Integer> future2 = e1.submit(t1);
		Future<Integer> future3 = e1.submit(t1);
		System.out.println(future1.get()+",-,"+future2.get()+",-,"+future3.get());
   }
}
class Ticket implements Callable<Integer>{
    private int total = 50;
	public Integer call() throws Exception {
		while (true) {
			if(total<=0){
				break;
			}
			Thread.sleep(500);
			System.out.println(Thread.currentThread().getName()+"抢到了第"+total--+"张票");
			
		}
		return total;
	}
	
	
}
class TicketThread implements Runnable{
	private int total = 50;
	public void run() {
		while (true) {
			if(total<=0){
				break;
			}
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"抢到了第"+total--+"张票");
			
		}
	}
	
}