package designPattern.facade;
/**
 * 
 * 描述：测试外观模式
 * @author gt
 * @created 2016年7月21日 下午11:32:30
 * @since
 */
public class Client {
    public static void main(String[] args) {
		RegisterFacade registerFacade = new RegisterFacade();
		registerFacade.openAccount();
	}
}
