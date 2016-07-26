package designPattern.Iterator;
/**
 * 
 * 描述：测试迭代器模式
 * @author gt
 * @created 2016年7月26日 下午11:43:13
 * @since
 */
public class Client {
    public static void main(String[] args) {
		ConcreteAggregate c1 = new ConcreteAggregate();
		c1.addObject("gutao");
		c1.addObject("nibei");
		c1.addObject("xiaopang");
		
		MyIterator iterator = c1.getIterator();
		while(iterator.hasNext()){
			System.out.println(iterator.getCurrentObj());
			iterator.next();
		}
	}
}
