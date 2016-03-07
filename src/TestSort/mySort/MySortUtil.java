package TestSort.mySort;

import java.util.List;

public class MySortUtil{
	public static  <T> void Sort(List<T> list){
		Object[] t = list.toArray();
		Sort(t);
		for (int i = 0; i < t.length; i++) {
			list.set(i, (T) t[i]);
		}
	}
	public static <T extends Comparable<T>> void Sort(T[] arr){
		   int count = 0;
		   for (int i = 0; i < arr.length-1; i++) {
			 for (int j = 0; j < arr.length-i-1; j++) {
				if(((Comparable)arr[j]).compareTo(arr[j+1])<0){
					T object = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = object;
				}
			}
		}
   }	
   public static void Sort(Object[] arr){
	   int count = 0;
	   for (int i = 0; i < arr.length-1; i++) {
		 for (int j = 0; j < arr.length-i-1; j++) {
			if(((Comparable)arr[j]).compareTo(arr[j+1])<0){
				Object object = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = object;
			}
		}
	}
   }	
   
}
