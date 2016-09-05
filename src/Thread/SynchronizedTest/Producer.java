package Thread.SynchronizedTest;
/**
 * 
 * 描述：生产者
 * @author gt
 * @created 2016年4月18日 下午3:36:15
 * @since
 */
public class Producer implements Runnable{
    private Product product;
    public Producer(Product product){
    	super();
    	this.product = product;
    }
	public void run() {
		for (int i = 0; i < 10; i++) {
			product.product("第"+(i+1)+"件商品");
		}
	}

}
