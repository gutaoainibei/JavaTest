package designPattern.strategy;

public class Context {
    strategy strategy;
	public Context(designPattern.strategy.strategy strategy) {
		super();
		this.strategy = strategy;
	}
    public void pritlnPrice(double d){
    	 System.out.println("按照策略进行处理");
    	 strategy.handler(d);
    }
}
