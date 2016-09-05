package designPattern.Factory.AbstractFactory;

public interface Seat {
     void massage();
}
class lowSeat implements Seat{

	public void massage() {
		System.out.println("不可以按摩");
	}
	
}
class luxurySeat implements Seat{

	public void massage() {
		System.out.println("可以按摩");
	}
	
}