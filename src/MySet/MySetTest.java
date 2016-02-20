package MySet;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 描述：学习Set的实现
 * @author gt
 * @created 2016年2月20日 下午4:54:44
 * @since
 */
public class MySetTest {
	private final static String PERSIST = "value";
	Map map = new HashMap();
	private int size;
	public int size(){
		this.size = map.size();
		return size;
	}
	public void add(Object object){
		map.put(object, PERSIST);
	}
   public static void main(String[] args) {
	   MySetTest mySetTest = new MySetTest();
	   mySetTest.add("gutao");
	   mySetTest.add("nibei");
	   System.out.println(mySetTest.size());
   }
}
