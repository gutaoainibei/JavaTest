package Thread.SynchronizedTest;
/**
 * 描述：
 * @author gt
 * @created 2016年4月18日 下午3:32:26
 * @since
 */
public class ProducerAndCustomer {
     public static void main(String[] args) {
		Product product = new Product();
		Producer producer = new Producer(product);
		Customer customer = new Customer(product);
		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(customer);
		t1.start();
		t2.start();
	}
}
