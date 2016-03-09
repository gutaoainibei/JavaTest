package TestSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import TestSort.mySort.MySortUtil;
import TestSort.mySort.MyString;
/**
 * 
 * 描述：测试自己实现的比较工具类
 * @author gt
 * @created 2016年3月8日 下午3:09:05
 * @since
 */
public class TestMyUtils {
	public static void main(String[] args) {
		Integer[] arr = {7,5,9,8,46,4,34};
		String[] str = {"acc","dcc","cdd","e"};
		Date[] dates = new Date[3];
		dates[0] = new Date();
		dates[1] = new Date(System.currentTimeMillis()-1000*60*60);
		dates[2] = new Date(System.currentTimeMillis()+1000*60*60);
		
		MySortUtil.Sort(arr);
		MySortUtil.Sort(str);
		MySortUtil.Sort(dates);
		System.out.println("=========my sort date method Sort(T[] dates) or Sort(Object[] obj)=============");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]+" ");
		}
		System.out.println("=========my sort date method Sort(T[] dates) or Sort(Object[] obj)=============");
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]+" ");
		}
		System.out.println("=========my sort date method Sort(T[] dates) or Sort(Object[] obj)=============");
		for (int i = 0; i < dates.length; i++) {
			System.out.println(dates[i]);
		}
		System.out.println("=========my sort list1 method Sort(List<T> list)=============");
		List<String> list1 = new ArrayList<String>();
		list1.add("adsdf");
		list1.add("dsd");
		list1.add("csss");
		list1.add("fsda");
		MySortUtil.Sort(list1);
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}
		System.out.println("=========my sort list2 method SOrt(List<T> list)=============");
		List<String> list2 = new ArrayList<String>();
		list2.add("adsdf");  
		list2.add("dsddddsdfsfsf");
		list2.add("css");
		list2.add("bsda");
		MySortUtil.Sort(list2, new MyString());
        for (int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i));
		}
		System.out.println("=========my sort list2 method SOrt(List<T> list,Comparator c)=============");
        List<String> listComparaotr = new ArrayList<String>();
		listComparaotr.add("adsdf");  
		listComparaotr.add("dsddddsdfsfsf");
		listComparaotr.add("css");
		listComparaotr.add("bsda");
		Collections.sort(listComparaotr, new MyString());//这是collect类给我们提供的一种比较方式
		for (int i = 0; i < listComparaotr.size(); i++) {
			System.out.println(listComparaotr.get(i));
		}
	}
}
