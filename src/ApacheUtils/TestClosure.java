package ApacheUtils;

import java.util.ArrayList;
import java.util.List;

import oracle.net.aso.e;
import oracle.net.aso.l;

import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.ChainedClosure;
import org.apache.commons.collections4.functors.IfClosure;
import org.apache.commons.collections4.functors.WhileClosure;

import ApacheUtils.model.Employee;
import ApacheUtils.model.Shop;

/**
 * 
 * 描述：1.函数式编程Closure闭包，封装特定的业务功能
 *      2.闭包加断言，实现一些特定的业务
 *        二选一ifClosure
 *        (Predicate predicate, trueClosure, falseClosure)
 * @author gt
 * @created 2016年3月22日 下午6:40:33
 * @since
 */
public class TestClosure {
   public static void main(String[] args) {
	   TestChainedClosure();
   }
   
   public static void TestChainedClosure(){
	   List<Shop> list = new ArrayList<Shop>();
       list.add(new Shop("电视机", 100.0, false));
       list.add(new Shop("电风扇", 200.0, false));
       //折上减
       Closure<Shop> subtractClosure = new Closure<Shop>() {
		public void execute(Shop shop) {
				shop.setPrice(shop.getPrice()-30);
		}
	   };
	   //打折
	   Closure<Shop> discountClosure = new Closure<Shop>() {
		public void execute(Shop shop) {
			shop.setPrice(shop.getPrice()*0.8);
		}
	    };
		Closure<Shop> ifClosure = ChainedClosure.chainedClosure(discountClosure, subtractClosure); 
		CollectionUtils.forAllDo(list, ifClosure);
		for (Shop shop : list) {
			System.out.println(shop);
		}
   }
   /**
    * 
    * 描述：WhileClosure.whileClosure(predicate, addClosure,true)
    * @author gt
    * @created 2016年3月22日 下午11:16:19
    * @since
    */
   public static void TestWhileClosure(){
	   List<Employee> list = new ArrayList<Employee>();
       list.add(new Employee("gutao", 9000));
       list.add(new Employee("nibei", 12000));
     
	   //不满10000就加工资
	   Closure<Employee> addClosure = new Closure<Employee>() {
		public void execute(Employee employee) {
				employee.setSalary(employee.getSalary()*1.2);
		}
	    };
	    //断言
	    Predicate<Employee> predicate = new Predicate<Employee>() {
			public boolean evaluate(Employee employee) {
				return employee.getSalary() < 10000;
			}
		};
		//false表示先判断在执行，而true表示先执行在判断
		Closure<Employee> whileClosure = WhileClosure.whileClosure(predicate, addClosure,true); 
        CollectionUtils.forAllDo(list, whileClosure);
        for (Employee employee : list) {
			System.out.println(employee);
		}
   }
   /**
    * 
    * 描述：测试(Predicate predicate, Closure trueClosure, Closure falseClosure)
    * @author gt
    * @created 2016年3月22日 下午10:57:28
    * @since
    */
   public static void TestIfClosure(){
	   List<Shop> list = new ArrayList<Shop>();
       list.add(new Shop("苹果手机", 6000.0, true));
       list.add(new Shop("电视机", 2000.0, false));
       list.add(new Shop("电风扇", 1500.0, false));
       //满1500减
       Closure<Shop> subtractClosure = new Closure<Shop>() {
		public void execute(Shop shop) {
			if(shop.getPrice() >= 1800){
				shop.setPrice(shop.getPrice()-300);
			}
		}
	   };
	   //打折
	   Closure<Shop> discountClosure = new Closure<Shop>() {
		public void execute(Shop shop) {
			shop.setPrice(shop.getPrice()*0.8);
		}
	    };
	    //断言
	    Predicate<Shop> predicate = new Predicate<Shop>() {
			public boolean evaluate(Shop shop) {
				return shop.isDiscount();
			}
		};
		//Open Declaration <Shop> Closure<Shop> 
		//org.apache.commons.collections4.functors.IfClosure.ifClosure
		//(Predicate<? super Shop> predicate, Closure<? super Shop> trueClosure, Closure<? super Shop> falseClosure)
		Closure<Shop> ifClosure = IfClosure.ifClosure(predicate, discountClosure, subtractClosure); 
		CollectionUtils.forAllDo(list, ifClosure);
		for (Shop shop : list) {
			System.out.println(shop);
		}
   }
   public static void TestClosure1(){
	   List<Employee> list = new ArrayList<Employee>();
		  list.add(new Employee("gutao", 10000));
		  list.add(new Employee("nibei", 7000));
		  list.add(new Employee("luoming", 8000));
		  Closure<Employee> closure = new Closure<Employee>() {
			public void execute(Employee employee) {
				employee.setSalary(employee.getSalary()*1.2);
			}
		  };
		  CollectionUtils.forAllDo(list, closure);
		  for (Employee employee : list) {
			System.out.println(employee);
		  }
   }
}
