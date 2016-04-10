package TestExtends.child1;
/**
 * 
 * 描述：下表为Java访问控制符的含义和使用情况

                      类内部	 本包	 子类	外部包 
public 	    √	 √	 √	 √
protected	√	 √	 √	 ×
default 	√	 √	 ×	 ×
private	    √	 ×	 ×	 ×
 * @author gt
 * @created 2016年4月10日 下午6:17:03
 * @since
 */
public class Parent {
   private String name;
   protected int age;
   String address;
   public String shop;
}
