package Annotation.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * 注解和注释其实区别就在于注解是可以被其他程序读取，而注释不行，注解也是解释的作用
 * 描述：测试注解SuppressWarnings,Deprecated
 *           SuppressWarnings:强压声明出来警告
 *           Deprecated：废弃的方法
 * @author gt
 * @created 2016年6月7日 下午5:21:28
 * @since
 */

public class TestBaseAnnotation {
	public String name;
    @Deprecated
	public void test() {

	}
	/*
	 * deprecation:使用了过时的类或者方法的警告,
	 * unchecked:执行了未检查的转换的警告，如使用集合时未指定泛型,
	 * fallthrough:当在switch中，发生case穿透,
	 * path:在源路径和类路径中，不存在路径的警告,
	 * serial:序列化类缺少声明的id,
	 * finally:任何finally子句不能完成时的警告,
	 * all:以上所有警告，
    */
    @Deprecated//用于解释，告诉使用者着方法不建议使用，已废弃的，但是并不代表不能使用
	public static void test1() {

	}
    @Deprecated
   	public static void test2() {
       test1();
   	}
    @SuppressWarnings("all")
	public static void main(String[] args) {
           test1();
           List list = new ArrayList<String>();
           TestBaseAnnotation t1 = new TestBaseAnnotation();
           t1.test();
	}
}
