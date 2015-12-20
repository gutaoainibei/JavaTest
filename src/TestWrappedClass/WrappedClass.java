package TestWrappedClass;
/**
 * 
* @ClassName: WrappedClass 
* @Description: TODO(测试基本数据类型的封装和解封装) 
* @author gutao 
* @date 2015年12月20日 下午9:30:02 
*
 */
public class WrappedClass {
	public static void main(String[] args) {
	    Integer i = new Integer("100");
        System.out.println(i);
        //左边是对象，右边是基本类型，理论上这是不对的
        //但是从JDK5.0以后我们开发人员在java编译其中加入了封装的操作使得基本类型可以了这样操作
        //同样反过来也是可以得
        Integer i1 = 100;
        //解封装
        int i3 = new Integer(10);
        Integer i4 = 1234;
        Integer i5 = 1234;
        System.out.println(i4 == i5);
        System.out.println(i4.equals(i5));
        //这里理论上下面两个通过"=="判断是不相等的但是这里确实是相等的
        //这是因为我们在编译其中缓存了-128~127的基本数字，所以这里比较的还是基本数据类型
        //他在后面自动的加了intValue()这个转换
        Integer i6 = 123;
        Integer i7 = 123;
        System.out.println(i6 == i7);
        System.out.println(i6.equals(i7));
	}
    
}
