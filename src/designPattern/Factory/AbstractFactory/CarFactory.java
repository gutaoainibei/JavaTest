package designPattern.Factory.AbstractFactory;

public interface CarFactory {
    Engine createEngine();
    Seat createSeat();
    Tyre createTyre();
}
class lowCarFactory implements CarFactory{

	public Engine createEngine() {
		return new lowEngine();
	}

	public Seat createSeat() {
		return new lowSeat();
	}

	public Tyre createTyre() {
		return new lowTyre();
	}
	
}
class luxuryCarFactory implements CarFactory{

	public Engine createEngine() {
		return new luxuryEngine();
	}

	public Seat createSeat() {
		return new luxurySeat();
	}

	public Tyre createTyre() {
		return new luxuryTyre();
	}
	
}