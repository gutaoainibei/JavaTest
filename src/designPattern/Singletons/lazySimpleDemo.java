package designPattern.Singletons;
/**
 * 
 * 描述：懒汉式单例模式
 * @author gt
 * @created 2016年7月4日 下午11:10:30
 * @since
 */
public class lazySimpleDemo {
    //懒加载，在需要用的时候再实例化
	private static lazySimpleDemo l1;
    
    private lazySimpleDemo(){
    	
    }
    //同步方法，调用效率低
    public synchronized static lazySimpleDemo getInstances(){
    	if (l1 == null) {
			l1 = new lazySimpleDemo();
		}
    	return l1;
    }
}
