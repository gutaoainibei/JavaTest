package designPattern.Prototype;
/**
 * 
 * 描述：浅克隆
 * @author gt
 * @created 2016年7月11日 下午11:46:01
 * @since
 */
public class Sheep implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
    	Object object = super.clone();
    	return object;
    }
}
