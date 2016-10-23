package JavaNetProgress;
/**
 * 
* @类名: TestThreadCallBack 
* @描述: TODO(这里用一句话描述这个类的作用) 
* @作者 gutao 
* @创建时间 2016年10月23日 下午8:59:28 
*
 */
public class TestThreadCallBack {
    public static void main(String[] args) {
		for (String string : args) {
			System.out.println(string);
		}
	}
}
abstract class callBackThread implements Runnable{
	private String fileName;
	public callBackThread(){}
	public callBackThread(String fileName) {
		super();
		this.fileName = fileName;
	}
    public abstract <T> T call();
	public void run() {
		
	}
}
