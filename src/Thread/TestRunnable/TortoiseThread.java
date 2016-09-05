package Thread.TestRunnable;
/**
 * 
 * 描述：乌龟线程
 * @author gt
 * @created 2016年4月11日 下午4:39:02
 * @since
 */
public class TortoiseThread implements Runnable{

	public void run() {
       for (int i = 0; i < 100; i++) {
		  System.out.println("乌龟跑了："+i+"步");
	   }		
	}

}
