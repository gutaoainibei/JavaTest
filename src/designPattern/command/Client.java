package designPattern.command;
/**
 * 
 * 描述：测试命令模式
 * @author gt
 * @created 2016年7月30日 下午6:22:37
 * @since
 */
public class Client {
    public static void main(String[] args) {
		Command command  = new ContreteCommand(new Receiver());
		Invoker invoker = new Invoker(command);
		invoker.call();
	}
}
