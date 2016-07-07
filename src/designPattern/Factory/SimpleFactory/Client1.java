package designPattern.Factory.SimpleFactory;
/**
 * 
 * 描述：测试简单工厂模式
 * @author gt
 * @created 2016年7月7日 下午11:18:31
 * @since
 */
public class Client1 {
    public static void main(String[] args) {
		Car audi = new Audi();
		Car benci = new Benci();
		audi.run();
		benci.run();
	}
}
