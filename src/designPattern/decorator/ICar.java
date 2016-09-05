package designPattern.decorator;

/**
 * 
 * 描述：抽象类
 * @author gt
 * @created 2016年7月20日 下午11:18:52
 * @since
 */
public interface ICar {
   public void move();
}
/**
 * 
 * 描述：真实需要被装饰的类
 * @author gt
 * @created 2016年7月20日 下午11:36:46
 * @since
 */
class Car implements ICar{

	public void move() {
		System.out.println("普通的跑");
	}
}
/**
 * 
 * 描述：装饰角色
 * @author gt
 * @created 2016年7月20日 下午11:37:20
 * @since
 */
class SuperCar implements ICar{
    private ICar car;
	public SuperCar(ICar car) {
		super();
		this.car = car;
	}
	public void move() {
		car.move();
	}
	
}
/**
 * 
 * 描述：具体装饰角色
 * @author gt
 * @created 2016年7月20日 下午11:43:17
 * @since
 */
class FlyCar extends SuperCar{
	public FlyCar(ICar car) {
		super(car);
	}
	@Override
	public void move() {
		super.move();
		fly();
	}
	public void fly(){
		System.out.println("车子飞着走");
	}
}
class WaterCar extends SuperCar{
	public WaterCar(ICar car) {
		super(car);
	}
	@Override
	public void move() {
		super.move();
		swim();
	}
	public void swim(){
		System.out.println("车子水里游");
	}
}