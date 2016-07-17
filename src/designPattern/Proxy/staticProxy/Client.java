package designPattern.Proxy.staticProxy;
/**
 * 
 * 描述：测试
 * @author gt
 * @created 2016年7月17日 下午11:52:55
 * @since
 */
public class Client {
    public static void main(String[] args) {
    	realStar realStar = new realStar();
		proxyStar proxy = new proxyStar(realStar);
		proxy.confer();
		proxy.signContract();
		proxy.bookTicket();
		proxy.collectMoney();
		proxy.sing();
	}
}
