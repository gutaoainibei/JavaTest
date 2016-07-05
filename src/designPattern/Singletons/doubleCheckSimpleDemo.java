package designPattern.Singletons;
/**
 * 
 * 描述：双重检测锁实现单例模式
 * @author gt
 * @created 2016年7月4日 下午11:48:32
 * @since
 */
public class doubleCheckSimpleDemo {
     private static doubleCheckSimpleDemo d1 = null;
     
     public static doubleCheckSimpleDemo getInstance(){
    	 if (d1 == null) {
			doubleCheckSimpleDemo demo ;
			synchronized (doubleCheckSimpleDemo.class) {
				demo = d1 ;
				if (demo == null) {
					synchronized (doubleCheckSimpleDemo.class) {
						if (demo == null) {
							demo = new doubleCheckSimpleDemo();
						}
					}
					d1 = demo;
				}
			}
		}
    	return d1;
     }
     private doubleCheckSimpleDemo(){}
}
