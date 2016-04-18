package Thread.SynchronizedTest;
/**
 * 
 * 描述：饿汉式设计模式
 *      1.构造器私有化
 *      2.声明私有的静态属性，同时创建该对象
 *      3.对外提供可供访问的属性的静态方法
 * @author gt
 * @created 2016年4月17日 下午11:00:08
 * @since
 */
public class MyJvm {

}
//这里同样是线程安全的静态的方法和属性，在类被调用的时候初始化，且只会初始化一次
class MyJvm1{
	private static MyJvm1 instance= new MyJvm1();
	private MyJvm1(){
		
	}
	public static MyJvm1 getInstance(){
		return instance;
	}
}
/**
 * 
 * 描述：采用内部类来实现，类在使用的时候加载，延迟了加载时间
 * @author gt
 * @created 2016年4月18日 上午9:48:07
 * @since
 */
class MyJvm2{
	private MyJvm2(){
		
	}
	private static class MyInstance{
		private static MyJvm2 jvm2 = new MyJvm2();
	}
	public static MyJvm2 getInstance(){
		return MyInstance.jvm2;
	}
}