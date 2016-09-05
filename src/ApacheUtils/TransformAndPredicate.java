package ApacheUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.SwitchTransformer;

import ApacheUtils.model.Employee;
import ApacheUtils.model.Level;

/**
 * 
 * 描述：函数式编程,类型转换,这里是一对一，这里希望大家要弄清楚
 *     Transformer
 * @author gt
 * @created 2016年3月21日 下午8:03:03
 * @since
 */
public class TransformAndPredicate {
    public static void main(String[] args) {
		Predicate lowSalary = new Predicate<Employee>() {
			public boolean evaluate(Employee employee) {
				return employee.getSalary() < 10000;
			}
		};
		Predicate highSalary = new Predicate<Employee>() {
			public boolean evaluate(Employee employee) {
				return employee.getSalary() > 10000;
			}
		};
		Predicate[] mypPredicate = {lowSalary,highSalary};
		Transformer<Employee, Level> lowLevel = new Transformer<Employee, Level>() {
			public Level transform(Employee employee) {
				return new Level(employee.getName(),"苦逼码农");
			}
		};
        Transformer<Employee, Level> highLevel = new Transformer<Employee, Level>() {
			public Level transform(Employee employee) {
				return new Level(employee.getName(), "架构师");
			}
		};
		Transformer[] transformers = {lowLevel,highLevel};
		Transformer switchTransformer = new SwitchTransformer(mypPredicate, transformers, null);
        List<Employee> list = new ArrayList<Employee>();
        list.add(new Employee("gutao", 999));
        list.add(new Employee("nibei", 99999));
		Collection<Level> collection = CollectionUtils.collect(list, switchTransformer);
		Iterator<Level> iterator = collection.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
    }
}
