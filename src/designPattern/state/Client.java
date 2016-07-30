package designPattern.state;
/**
 * 
 * 描述：测试状态方式
 * @author gt
 * @created 2016年7月31日 上午12:24:47
 * @since
 */
public class Client {
     public static void main(String[] args) {
		RoomContext r = new RoomContext();
		r.setState(new BookState());
		r.setState(new FreeState());
	}
}
