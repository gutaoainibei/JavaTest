package designPattern.strategy;

public class NewCustomerMany implements strategy{

	public void handler(double d) {
		System.out.println("打九折，因为你是新客户，不过进行了大批量购买！");
	}

}
