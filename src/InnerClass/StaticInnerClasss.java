package InnerClass;
/**
 * 
 * 描述：静态内部类测试
 * @author gt
 * @created 2016年7月3日 下午10:17:49
 * @since
 */
public class StaticInnerClasss {
    private String name;
    private static int age;
    public static class test1{
    	int price;
    	public void te(){
    		//静态内部类可以直接访问外部类的静态方法
    		test();
    		//静态内部类可以直接访问外部类的静态属性
    		System.out.println(age);
    	}
    }
    public static void test(){
    	
    }
}
