package designPattern.Factory.AbstractFactory;

public interface Tyre {
      void revolve();
}
class lowTyre implements Tyre{

	public void revolve() {
		System.out.println("磨损大");
	}
	
}
class luxuryTyre implements Tyre{

	public void revolve() {
		System.out.println("磨损小");
	}
	
}