package designPattern.Factory.SimpleFactory;
/**
 * 
 * 描述：汽车工厂
 * @author gt
 * @created 2016年7月7日 下午11:20:31
 * @since
 */
public class CarFactory {
       public static Benci createBenci(){
    	   return new Benci();
       }
       
       public static Audi createAudi(){
    	   return new Audi();
       }
       public static Dazhong createDazhong(){
    	   return new Dazhong();
       }
}
