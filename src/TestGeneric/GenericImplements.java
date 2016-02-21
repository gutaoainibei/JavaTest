package TestGeneric;
/**
 * 
 * 描述：泛型接口测试
 * @author gt
 * @created 2016年2月21日 下午4:43:31
 * @since
 * 泛型是不能修饰常量的
 * 在接口泛型修饰的是方法或者变量变量
 */
public interface GenericImplements <T>{
   public void test(T name);
}
//通过这个来测试泛型接口的一个应用规范
interface GenericImplements1 extends GenericImplements<String>{
	
}
