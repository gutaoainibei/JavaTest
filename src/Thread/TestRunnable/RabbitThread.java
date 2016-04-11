package Thread.TestRunnable;
/**
 * 
 * 描述：兔子线程
 * @author gt
 * @created 2016年4月11日 下午4:39:32
 * @since
 */
public class RabbitThread implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("兔子跑了："+i+"步");
		}
	}

}
