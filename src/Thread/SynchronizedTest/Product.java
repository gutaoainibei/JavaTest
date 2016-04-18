package Thread.SynchronizedTest;

/**
 * 
 * 描述：商品
 * @author gt
 * @created 2016年4月18日 下午3:34:43
 * @since
 */
public class Product{
    private String product;
    //用来判别当前是生产还是消费
    private boolean flag = true;//true:生产者生产,消费者等待
                                 //false：消费者消费，生产者等待
    public synchronized void product(String product){
       if(!flag){
    	    try {
			    this.wait();//等待并且释放锁
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
       }
       try {
		//模拟生产时间
		Thread.sleep(500);
	  	} catch (InterruptedException e) {
		e.printStackTrace();
	  	}
        System.out.println("生产了"+product);
        this.product = product;
        //可以消费了
        this.flag = false;
        //唤醒消费
        this.notify();
   
    }
    public synchronized void buy(){
    	if(flag){
    		try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    	try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        //开始消费
    	System.out.println("消费了"+product);
    	//可以生产
    	this.flag = true;
    	//唤醒生产
        this.notify();
    	
    }
}
