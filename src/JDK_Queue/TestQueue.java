package JDK_Queue;

import java.util.ArrayDeque;
import java.util.Queue;
/**
 * 
 * 描述：使用队列模仿银行存款业务
 * @author gt
 * @created 2016年3月11日 上午12:12:26
 * @since
 */
public class TestQueue {
   public static void main(String[] args) {
	 Queue<BankRequest>  arrayQueue = new ArrayDeque<BankRequest>();
	 for(int i = 0; i < 5 ;i++){
		 final int num = i+1;
		 arrayQueue.offer(new BankRequest() {
			@Override
			public void doposit() {
				System.out.println("第"+num+"个人办理业务,存款额度为："+(Math.random()*1000));
			}
		 });
	 }
	 dealWith(arrayQueue);
   }
   /**
    * 
    * 描述：poll()弹出并移除
    * @author gt
    * @created 2016年3月11日 上午12:34:50
    * @since 
    * @param queue
    */
   public static void dealWith(Queue<BankRequest> queue){
	   BankRequest request = null;
	   while((request=queue.poll())!=null){
         request.doposit();
	   }
	   System.out.println(queue.size());
   }
   /**
    * 
    * 描述：peek()弹出不移除，这里是个死循环
    * @author gt
    * @created 2016年3月11日 上午12:34:26
    * @since 
    * @param queue
    */
   public static void dealWith1(Queue<BankRequest> queue){
	   BankRequest request = null;
	   while((request=queue.peek())!=null){
         request.doposit();
	   }
	   System.out.println(queue.size());
   }
}
interface BankRequest{
	public void doposit();
}