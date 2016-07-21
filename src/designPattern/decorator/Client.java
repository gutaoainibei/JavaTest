package designPattern.decorator;

public class Client {
   public static void main(String[] args) {
	  Car car = new Car();
	  FlyCar flyCar = new FlyCar(car);
	  flyCar.move();
	  System.out.println("====================");
	  WaterCar waterCar = new WaterCar(flyCar);
	  waterCar.move();
	  System.out.println("====================");
	  WaterCar w1 = new WaterCar(car);
	  w1.move();
   }
}