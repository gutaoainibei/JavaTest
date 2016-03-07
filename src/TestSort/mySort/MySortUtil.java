package TestSort.mySort;

public class MySortUtil{

   public static void Sort(Object[] arr){
	   int count = 0;
	   int len = arr.length;
	   System.out.println(arr.length);
	   for (int i = 0; i < arr.length-1; i++) {
		   System.out.println(i);
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
