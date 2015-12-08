package TestAbstract;

public abstract class Animal {
	private int a;
	protected String name;
    public abstract void run();
    public void breath(){
    	System.out.println("呼吸");
    	System.out.println(this.getClass().getName());
    	run();
    }
    public Animal(){
    	System.out.println("抽象类构造器");
    }
}
class Cat extends Animal{

	public Cat(){
		super();
		System.out.println("Cat class");
	}
	@Override
	public void run() {
		System.out.println("爬----");
	}
	public void sound(){
		System.out.println("喵喵喵");
	}
	
}
class Dog extends Animal{

	public Dog(){
		super();
		System.out.println("Dog class");
	}
	@Override
	public void run() {
	   System.out.println("跑------");
	   name = "dog";
	   System.out.println("name:"+name);
	}
	public void sound(){
		System.out.println("汪汪汪");
	}
	
}
