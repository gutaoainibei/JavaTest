package designPattern.Observer;
/**
 * 
 * 描述：测试观察者模式
 * @author gt
 * @created 2016年7月31日 上午11:34:54
 * @since
 */
public class Client {
       public static void main(String[] args) {
		 ContreteSubject contreteSubject = new ContreteSubject();
		 
		 ObserverA o1 = new ObserverA();
		 ObserverA o2 = new ObserverA();
		 ObserverA o3 = new ObserverA();
		 
		 contreteSubject.register(o1);
		 contreteSubject.register(o2);
		 contreteSubject.register(o3);
		 
		 contreteSubject.setState(50);
         System.out.println(o1.getMyState());
         System.out.println(o2.getMyState());
         System.out.println(o3.getMyState());
         System.out.println(o1.getSubject().getState());//把对象也改变掉，如果一个人
         System.out.println(o2.getSubject().getState());
         System.out.println(o3.getSubject().getState());
         
         System.out.println("********************************");
         contreteSubject.setState(10);
         System.out.println(o1.getMyState());
         System.out.println(o2.getMyState());
         System.out.println(o3.getMyState());

      }
}
