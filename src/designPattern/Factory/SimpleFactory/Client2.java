package designPattern.Factory.SimpleFactory;
/**
 * 
 * 描述：单例模式
 * @author gt
 * @created 2016年7月7日 下午11:26:12
 * @since
 */
public class Client2 {
     public static void main(String[] args) {
		Car audi = CarFactory.createAudi();
		Car beCar = CarFactory.createBenci();
		Car daCar = CarFactory.createDazhong();
		audi.run();
		beCar.run();
		daCar.run();
	}
}
