package Thread.TestRunnable;
/**
 * 
 * 描述：测试线程 
 * @author gt
 * @created 2016年4月11日 下午4:44:05
 * @since
 */
public class MainThread {
     public static void main(String[] args) {
		Test12306Thread t1 = new Test12306Thread();
		Thread thread1 = new Thread(t1,"小明");
		Thread thread2 = new Thread(t1,"小红");
		Thread thread3 = new Thread(t1,"小军");
		thread1.start();
		thread2.start();
		thread3.start();
	}
     public static void TestThreadTortoisseAndRabbit(){
    	 TortoiseThread tortoise = new TortoiseThread();
 		RabbitThread rabbit = new RabbitThread();
 		Thread thread1 = new Thread(tortoise);
 		Thread thread2 = new Thread(rabbit);
 		thread1.start();
 		thread2.start();
 		for (int i = 0; i < 100; i++) {
 			System.out.println("gutao"+i+"nibei");
 		}
     }
}
