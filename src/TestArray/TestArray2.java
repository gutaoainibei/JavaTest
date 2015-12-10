package TestArray;

public class TestArray2 {
  public static void main(String[] args) {
	  int[] a = new int[4];
	  int[] b = {1,2,3,4};//数组也是一个对象，他的元素就是他的成员变量
	  //当new一个数组的时候，对象指向引用，引用中的每个元素又指向不同的对象实例，这才构成了数组
	  for(int i=0 ; i<a.length;i++){
		  a[i] = i;
	  }
	  
}
}
