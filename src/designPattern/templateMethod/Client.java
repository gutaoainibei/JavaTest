package designPattern.templateMethod;
/**
 * 
 * 描述：测试模板方式
 * @author gt
 * @created 2016年7月30日 下午11:57:28
 * @since
 */
public class Client {
   public static void main(String[] args) {
	DrawMoney d1 = new DrawMoney();
	d1.process();
	System.out.println("==============================");
	BankTemplateMethod bankTemplateMethod = new BankTemplateMethod() {
		@Override
		public void transact() {
			System.out.println("我要进行理财，我要投入10000000000000元，行吧！");
		}
	};
	bankTemplateMethod.process();
}
}
