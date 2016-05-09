package TestSequence;


/**
 * 
 * 描述：测试类的加载顺序
 *     从这里我们可以看到首先是加载静态块，然后是主函数（静态信息都会被加载到方法区中，这厮属于类信息，而普通的函数和属性属于对象），
 *     然后是非静态块
 *     最后是new的实例对象，也就是构造函数，这里要说明的是只有new对象之后才会去调用非静态块
 *     否则是不会调用的，而且是new一次调用一次非静态块
 * @author gt
 * @created 2016年5月9日 下午5:32:56
 * @since
 */
public class TestClassLoader {
	public static int a = 0;
    public TestClassLoader() {
        System.out.println("无参构造函数执行a=" + a);
    }
    static {
        a = 10;
        System.out.println("静态代码块在执行a=" + a);
    }

    {
        a = 8;
        System.out.println("非静态代码块在执行a=" + a);
    }
    public static void test() {
        System.out.println("=========静态方法=========");
    }
    public static void main(String[] args) {
    	TestClassLoader tsc = null;
        System.out.println("=========================");
        tsc = new TestClassLoader();
        tsc = new TestClassLoader();
    }
}
