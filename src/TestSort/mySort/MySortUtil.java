package TestSort.mySort;

import java.util.Comparator;
import java.util.List;

public class MySortUtil{
	
	public static <T> void Sort(List<T> list, Comparator<T> com){
		Object[] obj = list.toArray();
		for (int i = 0; i < obj.length-1; i++) {
			for (int j = 0; j < obj.length-1-i; j++) {
				if(com.compare((T)obj[j], (T)obj[j+1])<0){
					T temp = (T) obj[j];
					obj[j] = obj[j+1];
					obj[j+1] = temp;
				}
			}
		}
		for (int i = 0; i < obj.length; i++) {
			list.set(i, (T) obj[i]);
		}
	}
	
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
