package designPattern.state;
/**
 * 
 * 描述：房间
 * @author gt
 * @created 2016年7月31日 上午12:39:31
 * @since
 */
public class RoomContext {
     State state;

	public void setState(State state) {
		System.out.println("修改房间状态！");
		this.state = state;
		state.handle();
	}
    
}
