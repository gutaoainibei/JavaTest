package designPattern.Singletons;
/**
 * 
 * 描述：饿汉式单例模式
 * @author gt
 * @created 2016年7月4日 下午11:01:31
 * @since
 */
public class hungrySimpleDemo {
	  //类加载时立即初始化加载这个对象(没有延时加载)，加载类时天然的线程安全
      private static hungrySimpleDemo h1 = new hungrySimpleDemo();
      /**
       * 私有化构造器，只能自己访问
       */
      private hungrySimpleDemo(){
    	  
      }
      
      public static hungrySimpleDemo getInstances(){
    	  return h1;
      }
}
