package designPattern.Factory.AbstractFactory;

public interface Engine {
    void run();
    void start();
}
class luxuryEngine implements Engine{

	@Override
	public void run() {
		System.out.println("跑的快！");
	}

	@Override
	public void start() {
		System.out.println("开始快");
	}
	
}
class lowEngine implements Engine{

	@Override
	public void run() {
		System.out.println("跑的慢！");
	}

	@Override
	public void start() {
		System.out.println("发动慢");
	}
	
}