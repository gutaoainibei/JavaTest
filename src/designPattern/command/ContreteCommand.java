package designPattern.command;


public class ContreteCommand implements Command{
    Receiver receiver;
    
	public ContreteCommand(Receiver receiver) {
		super();
		this.receiver = receiver;
	}

	public void execute() {
		receiver.action();
	}

}
