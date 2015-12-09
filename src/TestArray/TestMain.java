package TestArray;

public class TestMain {
   public static void main(String[] args) {
	Car[] cars = new Car[3];
	//new出一个对象
	cars[0] = new Car("宝马");
	//再new出一个对象来
	cars[1] = new Car("宝马");
	System.out.println(cars[0].equals(cars[1]));
}
}
