package designPattern.templateMethod;
/**
 * 
 * 描述：银行处理业务的模板
 * @author gt
 * @created 2016年7月31日 上午12:01:03
 * @since
 */
public abstract class BankTemplateMethod {
     public void takeNumber(){
    	 System.out.println("排队取号！");
     }
     public abstract void transact();
     public void evaluate(){
    	 System.out.println("反馈评分！");
     }
     
     public void process(){
    	 this.takeNumber();
    	 this.transact();
    	 this.evaluate();
     }
}
