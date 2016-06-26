package ClassLoader.TestClassLoader;
/**
 * 
 * 描述：测试类加载器
 *      这里的加载模式采用了双亲加载模式，双亲加载模式就是
 *      无论自己想能否加载，先交给自己的父类去加载，然后如
 *      果父类加载不了，再交给下一层去加载，从引导类加载器
 *      到扩展类加载器到应用类加载器，最后到自定义类加载器
 *      这就是我们的双亲委托模式，这样是以安全为主，我们这
 *      样就无法去覆盖我们的原有的定义核心类
 * @author gt
 * @created 2016年6月24日 下午1:48:46
 * @since
 */
public class ClassLoaderTest {
   public static void main(String[] args) {
	System.out.println("应用类加载器:"+ClassLoader.getSystemClassLoader());
	System.out.println("扩展类加载器:"+ClassLoader.getSystemClassLoader().getParent());
	//这里因为我们的引导类加载器是用C写的所以无法加载到
	System.out.println("引导类加载器:"+ClassLoader.getSystemClassLoader().getParent().getParent());
}
}
