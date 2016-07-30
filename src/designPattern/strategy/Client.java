package designPattern.strategy;
/**
 * 
 * 描述：测试策略模式
 * @author gt
 * @created 2016年7月30日 下午7:02:32
 * @since
 */
public class Client {
   public static void main(String[] args) {
	strategy newFew = new NewCustomerFew();
	strategy newMany = new NewCustomerMany();
	strategy oldFew = new OldCustomerFew();
	strategy oldMany = new OldCustomerMany();
	Context context = new Context(oldMany);
	context.pritlnPrice(1000);
}
}
