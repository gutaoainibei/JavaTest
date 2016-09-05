package designPattern.Factory.AbstractFactory;

public interface Engine {
    void run();
    void start();
}
class luxuryEngine implements Engine{

	public void run() {
		System.out.println("跑的快！");
	}

	public void start() {
		System.out.println("开始快");
	}
	
}
class lowEngine implements Engine{

	public void run() {
		System.out.println("跑的慢！");
	}

	public void start() {
		System.out.println("发动慢");
	}
	
}