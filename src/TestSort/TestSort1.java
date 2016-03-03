package TestSort;

public class TestSort1 {
	//这里先写一个普通排序,按照从小到大
    public static void main(String[] args) {
		int[] arr = {7,5,9,8,46,4,34};
		for(int i = 0; i < arr.length-1;i++){
			System.out.println("第"+(i+1)+"轮:");
			for(int j = 0;j < arr.length-1;j++){
				System.out.print("第"+(j+1)+"次:");
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
				for (int i1 : arr) {
					System.out.print(i1+" ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
