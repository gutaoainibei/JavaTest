package designPattern.Adapter;
/**
 * 
 * 描述：调用者
 * @author gt
 * @created 2016年7月17日 下午11:21:56
 * @since
 */
public class Client {
	
  public void test(Target target){
	  target.adapterHandler();
  }
   public static void main(String[] args) {
	 Client client = new Client();
	 //需要适配的类
	 needAdaptee needAdaptee = new needAdaptee();
	 //进行适配
	 Target target = new Adapter(needAdaptee);
	 //调用
	 client.test(target);
}
}
