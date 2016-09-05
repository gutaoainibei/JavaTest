package ApacheUtils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.PredicateUtils;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.list.PredicatedList;

/**
 * 
 * 描述：断言
 * @author gt
 * @created 2016年3月20日 下午11:46:22
 * @since
 */
public class PredicateTest {
    public static void main(String[] args) {
		  System.out.println("====自定义判断====");
		  Predicate mypredicate = new Predicate<String>() {
			public boolean evaluate(String string) {
				return string.length()>5&&string.length()<11;
			}
		  };
		  Predicate notnull = NotNullPredicate.notNullPredicate();
		  Predicate all = PredicateUtils.allPredicate(notnull,mypredicate);
		  List<String> list = PredicatedList.predicatedList(new ArrayList<String>(), all);
		  list.add("gutao1");
		  //list.add("gutao");//报异常
		  list.add(null);
    }
    public static void unique(){
    	System.out.println("====唯一判断====");
		Predicate unique = UniquePredicate.uniquePredicate();
		List<Long> list = PredicatedList.predicatedList(new ArrayList<Long>(), unique);
        list.add(100L);
        list.add(1000L);
        //不能重复添加否则报错
        //  Exception in thread "main" java.lang.IllegalArgumentException: Cannot add Object '1000' - Predicate 'org.apache.commons.collections4.functors.UniquePredicate@7000a32b' rejected it
        //list.add(1000L);  
    }
    public static void testNotNullPredicate(){
    	System.out.println("====非空判断====");
		Predicate notnull = NotNullPredicate.notNullPredicate();
		String nameString = null;
		//非空为true，空位false
		System.out.println(notnull.evaluate(nameString));
		//添加容器的非空判断
		List<Long> list = PredicatedList.predicatedList(new ArrayList<Long>(),notnull);
	    list.add(100L);
	    list.add(null);//添加空值会报异常
    }
}
