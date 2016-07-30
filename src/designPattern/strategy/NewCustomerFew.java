package designPattern.strategy;

public class NewCustomerFew implements strategy{
	@Override
	public void handler(double d) {
		System.out.println("满一万块减10块！");
	}

}
