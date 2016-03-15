package Guava;

import java.util.Collection;
import java.util.List;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

/**
 * 
 * 描述：java中的函数式编程
 * @author gt
 * @created 2016年3月15日 下午11:37:18
 * @since
 */
public class TestFunctionProgress {
   public static void main(String[] args) {
	List<String> list = Lists.newArrayList();
	list.add("gutao");
	list.add("nibei");
	list.add("mom");
	//回文输出
	Collection<String> collection = Collections2.filter(list, new Predicate<String>() {
		@Override
		public boolean apply(String input) {
			return new StringBuilder(input).reverse().toString().equals(input);
		}
	});
	//过滤，规则自己实现
	Collection<String> collection1 = Collections2.filter(list, new Predicate<String>() {
		@Override
		public boolean apply(String input) {
			return input.length()>4;
		}
	});
	for (String string : collection) {
		System.out.println(string);
	}
	System.out.println("===========");
	for (String string : collection1) {
		System.out.println(string);
	}
}
}
