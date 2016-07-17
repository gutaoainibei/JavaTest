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

	@Override
	public void confer() {
		System.out.println("proxyStar.confer");
	}

	@Override
	public void signContract() {
		System.out.println("proxyStar.signContract");
	}

	@Override
	public void bookTicket() {
		System.out.println("proxyStar.bookTicket");
	}

	@Override
	public void sing() {
		realStar.sing();
	}

	@Override
	public void collectMoney() {
		System.out.println("proxyStar.collectMoney");
	}

}
