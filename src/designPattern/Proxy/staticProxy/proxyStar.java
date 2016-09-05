package designPattern.Proxy.staticProxy;
/**
 * 
 * 描述：静态代理类
 * @author gt
 * @created 2016年7月17日 下午11:53:07
 * @since
 */
public class proxyStar implements Star{
    private realStar realStar;
	public proxyStar(realStar realStar) {
		super();
		this.realStar = realStar;
	}

	public void confer() {
		System.out.println("proxyStar.confer");
	}

	public void signContract() {
		System.out.println("proxyStar.signContract");
	}

	public void bookTicket() {
		System.out.println("proxyStar.bookTicket");
	}

	public void sing() {
		realStar.sing();
	}

	public void collectMoney() {
		System.out.println("proxyStar.collectMoney");
	}

}
