package designPattern.state;
/**
 * 
 * 描述：登记入住
 * @author gt
 * @created 2016年7月31日 上午12:33:05
 * @since
 */
public class CheckedInState implements State{

	public void handle() {
		System.out.println("房间入住！请勿打扰！");
	}

}
