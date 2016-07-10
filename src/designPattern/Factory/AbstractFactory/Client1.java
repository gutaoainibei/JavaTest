package designPattern.Factory.AbstractFactory;
/**
 * 
 * 描述：抽象方法工厂
 * @author gt
 * @created 2016年7月7日 下午11:52:56
 * @since
 */
public class Client1 {
   public static void main(String[] args) {
	  CarFactory carFactory = new luxuryCarFactory();
	  Engine engine = carFactory.createEngine();
	  engine.run();
	  engine.start();
}
}
