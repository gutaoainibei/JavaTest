package TestSort;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import TestSort.mySort.MySortUtil;
import TestSort.mySort.MyString;

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
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i]+" ");
		}
		System.out.println();
		for (int i = 0; i < dates.length; i++) {
			System.out.println(dates[i]);
		}
		List<String> list1 = new ArrayList<String>();
		list1.add("adsdf");
		list1.add("dsd");
		list1.add("csss");
		list1.add("fsda");
		MySortUtil.Sort(list1);
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}
		System.out.println("=========my sort list2 my Comparator=============");
		List<String> list2 = new ArrayList<String>();
		list2.add("adsdf");
		list2.add("dsddddsdfsfsf");
		list2.add("css");
		list2.add("bsda");
		MySortUtil.Sort(list2, new MyString());
        for (int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i));
		}
	}
}
