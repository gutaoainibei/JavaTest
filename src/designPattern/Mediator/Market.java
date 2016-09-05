package designPattern.Mediator;

public class Market implements Department {
    private Mediator mediator;
    
	public Market(Mediator mediator) {
		super();
		this.mediator = mediator;
		this.mediator.register("market", this);
	}

	public void outAction() {
      System.out.println("汇报工作！项目承接的进度！需要资金支持！");
      mediator.command("finacial");
	}

	public void selfAction() {
      System.out.println("接项目");
	}

}
