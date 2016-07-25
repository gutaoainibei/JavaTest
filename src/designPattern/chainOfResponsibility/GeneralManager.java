package designPattern.chainOfResponsibility;

public class GeneralManager extends Leader{

	public GeneralManager(String name) {
		super(name);
	}

	@Override
	public void handlerRequest(leaveRequest leaveRequest) {
		if(leaveRequest.getDays() < 30){
			System.out.println(leaveRequest.getName()+"请假"+leaveRequest.getDays()+"天,等待批准！");
			System.out.println(name+"总经理审批通过！");
		}else{
			System.out.println("除了辞职，其他的不允许请假这么多天数！");
		}
	}

}
