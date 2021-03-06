package Thread.SynchronizedTest;
/**
 * 
 * 描述：单例设计模式
 * 确保一个类只有一个对象
 *      懒汉式
 *      1.构造器私有化，防止外部直接穿件对象
 *      2.声明一个私有化的静态变量
 *      3.创建一个对外的公共方法来获取这个成员变量，如果变量没有对象，就创建该对象
 *      此为懒汉式
 * @author gt
 * @created 2016年4月16日 下午9:03:03
 * @since
 */
public class SimpleStyleThread {
     public static void main(String[] args) {
    	 
	    JvmThread jvm1 = new JvmThread(1000);
	    JvmThread jvm2 = new JvmThread(500);
	    jvm1.start();
	    jvm2.start();
//    	 virtualJvm v1 = virtualJvm.getInstance(1000);
//    	 virtualJvm v2 = virtualJvm.getInstance(1000);
//    	 System.out.println(v1);
//    	 System.out.println(v2);
     }
}
/**
 * 
 * 描述：虚拟机线程
 * @author gt
 * @created 2016年4月17日 下午8:54:13
 * @since
 */
class JvmThread extends Thread{
	private long time;
	public JvmThread(){
		
	}
	public JvmThread(long time){
		this.time = time;
	}
	@Override
	public void run(){
		System.out.println("虚拟虚拟机地址："+virtualJvm.getInstance(time));
	}
}
/**
 * 描述：
 * @author gt
 * @created 2016年4月17日 下午8:55:04
 * @since
 */
class virtualJvm{
	private static virtualJvm jvm = null;
	private virtualJvm(){
		
	}
	/**
	 * 描述：获取对象
	 * @author gt
	 * @created 2016年4月17日 下午8:23:29
	 * @since 
	 * @return
	 */
	public static virtualJvm getInstance(long time){
		if (null == jvm) {//这一层为空判断是为了提高效率
			synchronized (virtualJvm.class) {
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(null == jvm){//这一层判断是为了安全，因为可能会存在延时，这样几个线程可能都已经通过了第一层判断，为了还能够保证一致，这里用了双重验证
				jvm = new virtualJvm();
				}
			}
		}
		return jvm;
	}
}
