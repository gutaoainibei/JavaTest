package designPattern.Factory.AbstractFactory;

public interface CarFactory {
    Engine createEngine();
    Seat createSeat();
    Tyre createTyre();
}
class lowCarFactory implements CarFactory{

	@Override
	public Engine createEngine() {
		return new lowEngine();
	}

	@Override
	public Seat createSeat() {
		return new lowSeat();
	}

	@Override
	public Tyre createTyre() {
		return new lowTyre();
	}
	
}
class luxuryCarFactory implements CarFactory{

	@Override
	public Engine createEngine() {
		return new luxuryEngine();
	}

	@Override
	public Seat createSeat() {
		return new luxurySeat();
	}

	@Override
	public Tyre createTyre() {
		return new luxuryTyre();
	}
	
}