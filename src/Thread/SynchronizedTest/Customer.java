package Thread.SynchronizedTest;
/**
 * 
 * 描述：
 * @author gt
 * @created 2016年4月18日 下午3:36:06
 * @since
 */
public class Customer implements Runnable{
    private Product product;
    public Customer(Product product){
    	this.product = product;
    }
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			product.buy();
		}
	}

}
