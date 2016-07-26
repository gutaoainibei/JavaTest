package designPattern.Iterator;
/**
 * 
 * 描述：自定义迭代器接口
 * @author gt
 * @created 2016年7月26日 下午11:43:45
 * @since
 */
public interface MyIterator {
    public void first();//指向第一个元素
    public void next();//指向下一个元素
    boolean hasNext();
    boolean isFirst();
    boolean isLast();
    public Object getCurrentObj();
}
