package Thread.JoinThread;


/**
 * 
 * 描述：线程阻塞
 *      1.join
 *      2.yield暂停自己的线程 static,写在那个线程体里面就暂停那个线程体
 *      “线程t1”在能被4整数的时候，并没有切换到“线程t2”。这表明，yield()
 *      虽然可以让线程由“运行状态”进入到“就绪状态”；但是，它不一定会让其它线程获取CPU执行权
 *      (即，其它线程进入到“运行状态”)，
 *      即使这个“其它线程”与当前调用yield()的线程具有相同的优先级
 *      
 *      wait()的作用是让当前线程由“运行状态”进入“等待(阻塞)状态”的同时，也会释放同步锁。
 *      而yield()的作用是让步，它也会让当前线程离开“运行状态”。它们的区别是：
        (01) wait()是让线程由“运行状态”进入到“等待(阻塞)状态”，而yield()
                            是让线程由“运行状态”进入到“就绪状态”。
        (02) wait()是会线程释放它所持有对象的同步锁，而yield()方法不会释放锁。
 * @author gt
 * @created 2016年4月12日 下午10:10:40
 * @since
 */
public class TestYeildThread {
	 private static Object obj = new Object();
     public static void main(String[] args) throws InterruptedException {
    	  //这里要注意一个问题内部类，可以当作外部类的一个属性来看，所以要想像下面一样实例化
    	  //那么就必须是静态内部类，否则在静态方法中不能直接调用非静态属性
    	  TestSynchronizedAndYeild t1 = new TestSynchronizedAndYeild("gt");
    	  TestSynchronizedAndYeild t2 = new TestSynchronizedAndYeild("nb");
          t1.start();
          t2.start();
     }
     public static void test1(){
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
     public static void test2(){
    	 ThreadA t1 = new ThreadA("t1"); 
         ThreadA t2 = new ThreadA("t2"); 
         t1.start(); 
         t2.start();
     }
     static class TestSynchronizedAndYeild extends Thread{
    	   public TestSynchronizedAndYeild(String name) {
    		   super(name);
    		   
		   }
    	   
			public void run() {
		//主线程main中启动了两个线程t1和t2。t1和t2在run()会引用同一个对象的同步锁，
	    //即synchronized(obj)。在t1运行过程中，虽然它会调用Thread.yield()；但是，
	    //t2是不会获取cpu执行权的。因为，t1并没有释放“obj所持有的同步锁”！
		      synchronized(obj){
				for (int i = 0; i < 10; i++) {
					System.out.printf("%s [%d] :%d\n", Thread.currentThread().getName(),this.getPriority(),i);
				    if (i%4==0) {
						Thread.yield();
					}
				}
			 }
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

class ThreadA extends Thread{
	    public ThreadA(String name){ 
	        super(name); 
	      } 
	     public synchronized void run(){ 
	          for(int i=0; i <10; i++){ 
	            System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i); 
	              // i整除4时，调用yield
	             if (i%4 == 0)
	            	 System.out.println("进入就绪"+i);
	                 Thread.yield();
	         } 
	     } 
 } 
