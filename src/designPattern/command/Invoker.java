package designPattern.command;
/**
 * 
 * 描述：发起请求命令者
 * @author gt
 * @created 2016年7月30日 下午6:54:58
 * @since
 */
public class Invoker {
    Command command;

	public Invoker(Command command) {
		super();
		this.command = command;
	}
    public void call(){
    	command.execute();
    }
}
