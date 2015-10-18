package TestSameFile;

import java.util.Arrays;

public class Test31 extends Test11{
  public static void main(String[] args) {
//	  int array[] = new int [5];
//  	  for (int i = 5; i > 0; i--)
//          array[5 - i] = i;
//      Arrays.sort(array);
//      for (int i = 0; i < 5; ++i)
//      	System.out.print(array[i]);
	  
//	  int array[] = new int [5];
//      for (int i = 5; i > 0; i--)
//          array[5-i] = i;
//      //把array这个数组从从array[1]到array[3],替换成8
//      //第一个参数是目标数组，第二个目标是开始的index（包含在内），第二个是结束的index不包含在内，第三个是替换数
//      Arrays.fill(array, 1, 4, 8);
//     
//      for (int i = 0; i < 5 ; i++)
//          System.out.print(array[i]);
	  
	  int array[] = new int [5];
      for (int i = 5; i > 0; i--)
          array[5 - i] = i;
      //output：1，2，3，4，5
      Arrays.sort(array);
      //第一个参数是目标数组，第二个参数是要搜寻的数
      System.out.print(Arrays.binarySearch(array, 4));
      //返回的是index of the search key
  
}
}
