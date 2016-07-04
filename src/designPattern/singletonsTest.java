package designPattern;

import designPattern.Singletons.enumSimpleDemo;
import designPattern.Singletons.hungrySimpleDemo;
import designPattern.Singletons.lazySimpleDemo;
import designPattern.Singletons.staticSimpledemo;

/**
 * 
 * 描述：测试单例模式
 * @author gt
 * @created 2016年7月4日 下午10:49:57
 * @since
 */
public class singletonsTest {
       public static void main(String[] args) {
		hungrySimpleDemo h1 = hungrySimpleDemo.getInstances();
		hungrySimpleDemo h2 = hungrySimpleDemo.getInstances();
		System.out.println(h1);
		System.out.println(h2);
		
		lazySimpleDemo l1 = lazySimpleDemo.getInstances();
		lazySimpleDemo l2 = lazySimpleDemo.getInstances();
		System.out.println(l1);
		System.out.println(l2);
		
		staticSimpledemo s1 = staticSimpledemo.getInstances();
		staticSimpledemo s2 = staticSimpledemo.getInstances();
		System.out.println(s1);
		System.out.println(s2);
		
		System.out.println(enumSimpleDemo.Instance == enumSimpleDemo.Instance);
	}
}
