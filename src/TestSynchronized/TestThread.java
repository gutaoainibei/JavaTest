package TestSynchronized;
/**
 * 
 * 描述：这里暂时就写一个简单线程的小列子，后面会详细的写线程的列子和多线程
 * @author gt
 * @created 2016年3月14日 下午11:45:26
 * @since
 */
public class TestThread extends Thread{
   public static void main(String[] args) {
	  TestThread testThread = new TestThread();
	  testThread.start();
	  System.out.println("gutao");
   }
   public void run(){
	   while (true) {
		   try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("线程开始");
	}

   }
}
