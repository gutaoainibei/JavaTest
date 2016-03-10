package JDKEnumeration;

import java.util.StringTokenizer;
/**
 * 
 * 描述：熟悉Enumeration的子类
 *  StringTokenizer
 * @author gt
 * @created 2016年3月10日 下午7:57:36
 * @since
 */
public class TestStringTokenizer {
	public static void main(String[] args) {
		String str = "gutao.com;nibei.com;gutaoainibei.com";
		//这里起到一个切割的作用 StringTokenizer是Enumeration的子类
		StringTokenizer strTokenizer = new StringTokenizer(str, ";");
		while(strTokenizer.hasMoreElements()){
			System.out.println(strTokenizer.nextElement());
		}
	}
}
