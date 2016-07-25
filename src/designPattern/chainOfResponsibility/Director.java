package designPattern.chainOfResponsibility;

public class Director extends Leader{

	public Director(String name) {
		super(name);
	}

	@Override
	public void handlerRequest(leaveRequest leaveRequest) {
		if(leaveRequest.getDays() < 3){
			System.out.println(leaveRequest.getName()+"请假"+leaveRequest.getDays()+"天,等待批准！");
			System.out.println(name+"总监审批通过！");
		}else{
			if(this.nextLeader != null){
				this.nextLeader.handlerRequest(leaveRequest);
			}
		}
	}

}
