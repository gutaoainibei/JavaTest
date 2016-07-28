package designPattern.Mediator;
/**
 * 
 * 描述：测试中介者模式
 * @author gt
 * @created 2016年7月27日 下午11:34:52
 * @since
 */
public class Client {
    public static void main(String[] args) {
		Mediator mediator = new President();
		Development development = new Development(mediator);
		Finacial finacial = new Finacial(mediator);
		Market market = new Market(mediator);
		
		market.selfAction();
		market.outAction();
	}
}
