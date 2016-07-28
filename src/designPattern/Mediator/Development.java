package designPattern.Mediator;

public class Development implements Department {
    private Mediator mediator ;
    
	public Development(Mediator mediator) {
		super();
		this.mediator = mediator;
		this.mediator.register("development", this);
	}

	@Override
	public void outAction() {
        System.out.println("汇报工作！没钱了，需要资金支持！");
	}

	@Override
	public void selfAction() {
       System.out.println("专心搞科研！");
	}

}
