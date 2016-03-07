package TestSort;

import TestSort.mySort.MySortUtil;

public class TestMyUtils {
	public static void main(String[] args) {
		Integer[] arr = {7,5,9,8,46,4,34};
		MySortUtil.Sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
