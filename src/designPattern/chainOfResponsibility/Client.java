package designPattern.chainOfResponsibility;
/**
 * 
 * 描述：测试责任链模式
 * @author gt
 * @created 2016年7月25日 下午11:31:33
 * @since
 */
public class Client {
    public static void main(String[] args) {
		Director d = new Director("gt");
		Manager m = new Manager("nb");
		GeneralManager g = new GeneralManager("gn");
		d.setNextLeader(m);
		m.setNextLeader(g);
		leaveRequest leaveRequest = new leaveRequest("小四", 2, "家里有事");
		d.handlerRequest(leaveRequest);
		System.out.println("-----------------------------");
		leaveRequest leaveRequest2 = new leaveRequest("小三", 5, "看病");
		d.handlerRequest(leaveRequest2);
		System.out.println("--------------------------------------");
		leaveRequest leaveRequest3 = new leaveRequest("小五", 20, "结婚");
		d.handlerRequest(leaveRequest3);
		System.out.println("-----------------------------------");
		leaveRequest leaveRequest4 = new leaveRequest("小五", 30, "辞职");
		d.handlerRequest(leaveRequest4);
	}
}
