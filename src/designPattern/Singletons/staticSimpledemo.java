package designPattern.Singletons;
/**
 * 
 * 描述：静态内部类单例模式
 * @author gt
 * @created 2016年7月4日 下午11:21:30
 * @since
 */
public class staticSimpledemo {
    //需要用的时候再加载
    private staticSimpledemo(){
    	
    }
    private static class Instance{
    	private static final staticSimpledemo s1 = new staticSimpledemo();
    }
    //需要的时候再加载，利用加载类时候的天然线程安全
    public static staticSimpledemo getInstances(){
    	return staticSimpledemo.Instance.s1;
    }
}
