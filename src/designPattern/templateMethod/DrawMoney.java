package designPattern.templateMethod;

public class DrawMoney extends BankTemplateMethod{

	@Override
	public void transact() {
		System.out.println("存钱，我要存100000元");
	}

}
