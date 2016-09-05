package Thread.SynchronizedTest;
/**
 * 
 * 描述：模仿死锁。在java线程程序中，之所以会死锁
 *     很多时候是因为
 * @author gt
 * @created 2016年4月18日 上午11:00:36
 * @since
 */
public class TestDeadLock {
    public static void main(String[] args) {
    	Object good = new Object();
    	Object money = new Object();
		Test2 t2 = new Test2(good , money);
		Test3 t3 = new Test3(good, money);
		Thread thread1 = new Thread(t2, "给我货，我给你钱");
		Thread thread2 = new Thread(t3, "给我钱，我给你货");
		thread1.start();
		thread2.start();
	}
}
class Test2 implements Runnable{
	Object good;
	Object money;
	public Test2(Object good , Object money) {
        this.good = good;
        this.money = money;
	}
	public void run() {
		while (true) {
			System.out.println("要货开始");
			synchronized (good) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (money) {
					
				}
			}
			System.out.println("你给我货，我给你钱");
		}
	}
}
class Test3 implements Runnable{
	Object good;
	Object money;
	public Test3(Object good , Object money) {
        this.good = good;
        this.money = money;
	}
	public void run() {
		while (true) {
			System.out.println("要钱开始");
			synchronized (money) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (good) {
					
				}
			}
			System.out.println("你给我钱，我给你货");
		}
	}
}