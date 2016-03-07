package TestSort.mySort;

import java.util.Comparator;

public class MyString implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		int len1 = o1.length();
		int len2 = o2.length();
		int compare = len1 > len2 ? -1 : 0;
		return compare;
	}

}
