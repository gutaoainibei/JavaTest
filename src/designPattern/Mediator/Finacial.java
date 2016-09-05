package designPattern.Mediator;

public class Finacial implements Department {
    private Mediator mediator;
    
	public Finacial(Mediator mediator) {
		super();
		this.mediator = mediator;
		this.mediator.register("finacial", this);
	}

	public void outAction() {
      System.out.println("钱太多了怎么花");
      mediator.command("finacial");
	}

	public void selfAction() {
      System.out.println("记账数钱");
	}

}
