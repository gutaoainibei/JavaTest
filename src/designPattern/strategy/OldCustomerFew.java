package designPattern.strategy;

public class OldCustomerFew implements strategy{

	@Override
	public void handler(double d) {
		System.out.println("打九点五折，因为是老客户，不过只少量购买了！要是买多点可以有更多优惠");
	}

}
