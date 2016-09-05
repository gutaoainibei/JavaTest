package designPattern.state;
/**
 * 
 * 描述：
 * @author gt
 * @created 2016年7月31日 上午12:36:29
 * @since
 */
public class BookState implements State {

	public void handle() {
         System.out.println("房间已经预定！别人不能订！");
	}

}
