package designPattern.chainOfResponsibility;

public class Manager extends Leader{

	public Manager(String name) {
		super(name);
	}

	@Override
	public void handlerRequest(leaveRequest leaveRequest) {
		if(leaveRequest.getDays() < 10){
			System.out.println(leaveRequest.getName()+"请假"+leaveRequest.getDays()+"天,等待批准！");
			System.out.println(name+"经理审批通过！");
		}else{
			if(this.nextLeader != null){
				this.nextLeader.handlerRequest(leaveRequest);
			}
		}
	}

}
