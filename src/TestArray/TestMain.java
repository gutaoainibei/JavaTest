package TestArray;
public class TestMain {
   static final int test = 3;
   public static void main(String[] args) {
//	Car[] cars = new Car[3];
//	//new出一个对象
//	cars[0] = new Car("宝马");
//	//再new出一个对象来
//	cars[1] = new Car("宝马");
//	System.out.println(cars[0].equals(cars[1]));
	   //虽然我我们用final修饰了数组a但是它里面的元素还是可以变的，因为我们
	   //只修饰了数组不可以变，他属性的引用使用可以变得
	
	final int[] a={1,3,2};
	for(int i = 0;i<a.length;i++){
		a[i]=3-i;
	}
	for(int i = 0;i<a.length;i++){
		System.out.print(a[i]);
		System.out.print(" ");
	}
}
}
