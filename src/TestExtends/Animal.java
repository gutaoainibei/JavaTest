package TestExtends;

public class Animal {
    private String idn;
    String name="gutao";
    int id=1;
    public Animal(){
    	System.out.println("Animal 类的构造");
    }
    public void run(){
    	System.out.println("行动");
    }
    public void huxi(){
    	System.out.println(this.getClass().getName());
    	System.out.println("呼吸");
    }
    public static void main(String[] args) {
//		Person person = new Person();
		ChildBird childBird = new ChildBird();
		Bird bird = new Bird();
		childBird.huxi();
		bird.huxi();
//		person.run();
//		childBird.run();
//		bird.run();
//		System.out.println(person.name);
//		System.out.println(childBird.name);
//		System.out.println(bird.name);
	}
}
//构造函数在在函数中的第一句是super(),这是不管你写没写编译器都会给你加上的，还有每个方法都有两个隐式参数
//一个是this，一个是super
class Bird extends Animal{
	String eat;
	String name="鸟类";
	public Bird(){
		System.out.println("Bird 类的构造");
	}
//	public void run(){
//		System.out.println("飞翔-------------");
//	}
}
class ChildBird extends Bird{
	String name="小鸟";
	public ChildBird(){
	//	super();
		System.out.println("ChildBird 类的构造");
	}
	public void eat(){
		System.out.println("小鸟吃东西");
	}
//	public void run(){
//		System.out.println("跳起来-------------");
//	}
}
class Person extends Animal{
	public void talk(){
		System.out.println("语言交谈");
	}
}