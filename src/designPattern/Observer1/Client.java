package designPattern.Observer1;
/**
 * 
 * 描述：测试junit原来有的观察者模式
 * @author gt
 * @created 2016年7月31日 下午12:49:29
 * @since
 */
public class Client {
    public static void main(String[] args) {
    	
    	Observerzable subject = new Observerzable();
		Observertest o1 = new Observertest();
		Observertest o2 = new Observertest();
		Observertest o3 = new Observertest();

        subject.addObserver(o1);
        subject.addObserver(o2);
        subject.addObserver(o3);
        
        subject.setState(1000);
        
        System.out.println(o1.getMystate());
        System.out.println(o2.getMystate());
        System.out.println(o3.getMystate());
		
	}
}
