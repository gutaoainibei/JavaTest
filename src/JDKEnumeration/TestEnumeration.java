package JDKEnumeration;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * 
 * 描述：Enumeration的使用
 * 1.判断hasMoreElements()
 * 2.获取nextElement()
 * Vector 的elements()方法
 * @author gt
 * @created 2016年3月10日 下午7:30:31
 * @since
 */
public class TestEnumeration {
	public static void main(String[] args) {
	    Vector<String> vector = new Vector<String>();
        vector.add("gutao");
        vector.add("nibei");
        vector.add("luoming");
        Enumeration<String> enumeration = vector.elements();
        System.out.println("===========Enumeration迭代（这是一种比较古老的迭代方式）==============");
        while(enumeration.hasMoreElements()){
       	 System.out.println(enumeration.nextElement());
        }
        System.out.println("===========iterator迭代==============");
        Iterator<String> iterator = vector.iterator();
	     while(iterator.hasNext()){
	    	 System.out.println(iterator.next());
	     }	
	}
}
