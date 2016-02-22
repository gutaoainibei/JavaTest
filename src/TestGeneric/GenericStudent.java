package TestGeneric;
/**
 * 
 * 描述：泛型类测试
 * @author gt
 * @created 2016年2月21日 下午4:56:51
 * @since
 * 泛型不能修饰常量
 * 泛型只能修饰方法和属性，参数变量
 */
public class GenericStudent<T> {
	T name;

	public T getName() {
		return name;
	}

	public void setName(T name) {
		this.name = name;
	}
    public static void main(String[] args) {
		GenericStudent g1 = new GenericStudent();
		g1.test1(g1);
		//这里解释了泛型擦除不等于Object
		GenericStudent<Object> g2 = new GenericStudent<Object>();
		//g1.test1(g2);
	}
    public static void test1(GenericStudent<String> g){
    	
    }
}
class ChildStudent extends GenericStudent<String>{
	 public void test(){
		 name = "gutao";
		 System.out.println(name);
	 }
}
