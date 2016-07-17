package designPattern.Adapter;
/**
 * 
 * 描述：适配器
 * @author gt
 * @created 2016年7月17日 下午11:21:24
 * @since
 */
public class Adapter implements Target{
    private needAdaptee adaptee;
	@Override
	public void adapterHandler() {
		adaptee.test();
	}
	public Adapter(needAdaptee adaptee) {
		super();
		this.adaptee = adaptee;
	}
    
}
