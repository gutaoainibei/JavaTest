package designPattern.Proxy.staticProxy;
/**
 * 
 * 描述：真实类他和代理类是实现了一个接口
 * @author gt
 * @created 2016年7月17日 下午11:53:28
 * @since
 */
public class realStar implements Star{

	public void confer() {
		System.out.println("realStar.confer");
	}

	public void signContract() {
		System.out.println("realStar.signContract");
	}

	public void bookTicket() {
		System.out.println("realStar.bookTicket");
	}

	public void sing() {
		System.out.println("realStar.sing");
	}

	public void collectMoney() {
		System.out.println("realStar.collectMoney");
	}

}
