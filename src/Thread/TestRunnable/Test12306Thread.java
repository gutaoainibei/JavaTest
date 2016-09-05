package Thread.TestRunnable;
/**
 * 
 * 描述：模拟线程
 * @author gt
 * @created 2016年4月11日 下午4:54:33
 * @since
 */
public class Test12306Thread implements Runnable{
    private boolean flag = true;
    private int num = 50;
	public void run() {
		while (flag) {
			if(num < 0){
				System.out.println("============================");
				break;
			}
			System.out.println(Thread.currentThread().getName()+"::"+num--);
		}
	}

}
