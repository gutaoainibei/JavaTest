package TestAbstract;

public interface FlyAttach {
	//接口中，常量都是public static final修饰的
	//方法都是public abstract修饰的
	//里面必须是常量
     int a = 1111;
     public void fly();
     public String name();
}
class Thing implements FlyAttach{

	public void fly() {
		System.out.println("飞飞飞");
	    System.out.println(a);
	}

	public String name() {
		System.out.println("叫什么名字");
		return "gutao";
	}
	
}