package ApacheUtils;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.NotNullPredicate;

/**
 * 
 * 描述：断言
 * @author gt
 * @created 2016年3月20日 下午11:46:22
 * @since
 */
public class PredicateTest {
    public static void main(String[] args) {
		System.out.println("====非空判断====");
		Predicate notnull = NotNullPredicate.notNullPredicate();
		String nameString = null;
		//非空为true，空位false
		System.out.println(notnull.evaluate(nameString));
	}
}
