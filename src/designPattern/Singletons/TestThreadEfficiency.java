package designPattern.Singletons;

import java.util.concurrent.CountDownLatch;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 
 * 描述：测试各个单例模式的效率
 * @author gt
 * @created 2016年7月5日 下午11:56:41
 * @since
 */
public class TestThreadEfficiency {
   public static void main(String[] args) throws InterruptedException {
	long startTime = System.currentTimeMillis();
	int threadNum = 10;
	final CountDownLatch countDownLatch = new CountDownLatch(threadNum);
	for (int i = 0; i < threadNum; i++) {
		new Thread(new Runnable() {
			public void run() {
				for (int j = 0; j < 100000; j++) {
					//Object o = lazySimpleDemo.getInstances();//44ms
					//Object o = hungrySimpleDemo.getInstances();//14ms
					//Object o = doubleCheckSimpleDemo.getInstance();//17ms
					//Object object = staticSimpledemo.getInstances();//37ms
					//Object object = enumSimpleDemo.Instance;//11ms
				}
				countDownLatch.countDown();
			}
		}).start();
	}
	countDownLatch.await();//main线程阻塞，知道技术器变为0，才会继续往下执行
	long endTime = System.currentTimeMillis();
	System.out.println("用时："+(endTime-startTime));
	
}
}
