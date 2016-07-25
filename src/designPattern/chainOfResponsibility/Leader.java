package designPattern.chainOfResponsibility;
/**
 * 
 * 描述：领导抽象类
 * @author gt
 * @created 2016年7月25日 下午11:35:02
 * @since
 */
public abstract class Leader {
    protected String name;
    protected Leader nextLeader;
	public Leader(String name) {
		super();
		this.name = name;
	}
	public void setNextLeader(Leader nextLeader) {
		this.nextLeader = nextLeader;
	}
    public abstract void handlerRequest(leaveRequest leaveRequest);
}
