package Guava;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.logging.SimpleFormatter;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * 
 * 描述：java中的函数式编程
 * Predicate
 * Function
 * 
 * 1.Collections2.filter()过滤器
 * 2.
 * @author gt
 * @created 2016年3月15日 下午11:37:18
 * @since
 */
public class TestFunctionProgress {
   public static void main(String[] args) {
	   
   }
   /**
    * 
    * 描述：组合式函数编程
    * @author gt
    * @created 2016年3月16日 下午9:24:04
    * @since
    */
   public static void test3(){
	   List<String> list = Lists.newArrayList("gutao","nibeiaigutao","luoming");
       //组合式函数编程
	   //确保容器中的字符串长度都不超过5，超过5的截取前面的，然后把字符串全部大写
	   Function<String, String> f1 = new Function<String, String>() {
		@Override
		public String apply(String input) {
			return input.length() > 5 ? input.substring(0,5):input;
		}
	   };
	   Function<String, String> f2 = new Function<String, String>() {
		@Override
		public String apply(String input) {
			return input.toUpperCase();
		}
	};
	Function<String, String> f = Functions.compose(f1, f2);
	Collection<String> collection = Collections2.transform(list, f);
	for (String string : collection) {
		System.out.println(string);
	}
   }
   /**
    * 
    * 描述：类型转换
    * @author gt
    * @created 2016年3月16日 下午8:15:51
    * @since
    */
   public static void test2(){
	   //类型转换
	   Set<Long> set = Sets.newHashSet();
	   set.add(10000000L);
	   set.add(50000000000000L);
	   set.add(3000000000L);
	   Collection<String> collection = Collections2.transform(set,new Function<Long,String>() {
			@Override
			public String apply(Long input) {
				return new SimpleDateFormat("yyyy-MM-dd").format(input);
			}
	   });
	   for (String string : collection) {
		  System.out.println(string);
	   }
   }
   /**
    * 
    * 描述：过滤
    * @author gt
    * @created 2016年3月16日 下午6:53:20
    * @since
    */
   public static void test1(){
		List<String> list = Lists.newArrayList();
		list.add("gutao");
		list.add("nibei");
		list.add("mom");
		//过虑，回文输出（这个规则是自己建的）
		Collection<String> collection = Collections2.filter(list, new Predicate<String>() {
			@Override
			public boolean apply(String input) {
				return new StringBuilder(input).reverse().toString().equals(input);
			}
		});
		//过滤，长度要大于4的（规则自己定，实现即可）
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
