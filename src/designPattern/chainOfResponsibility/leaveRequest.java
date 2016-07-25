package designPattern.chainOfResponsibility;

/**
 * 
 * 描述：请求
 * 
 * @author gt
 * @created 2016年7月25日 下午11:32:41
 * @since
 */
public class leaveRequest {
	private String name;
	private int days;
	private String reason;

	public leaveRequest(String name, int days, String reason) {
		super();
		this.name = name;
		this.days = days;
		this.reason = reason;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
