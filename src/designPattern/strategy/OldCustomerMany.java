package designPattern.strategy;


public class OldCustomerMany implements strategy{

	@Override
	public void handler(double d) {
		System.out.println("打八折，因为是老客户，还是大批量购买");
	}

}
