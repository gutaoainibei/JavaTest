package TestExtends;

public class Animal {
    private String idn;
    String name="gutao";
    int id=1;
    public void run(){
    	System.out.println("行动");
    }
    public void huxi(){
    	System.out.println("呼吸");
    }
    public static void main(String[] args) {
		Person person = new Person();
		ChildBird childBird = new ChildBird();
		Bird bird = new Bird();
		person.run();
		childBird.run();
		bird.run();
		System.out.println(person.name);
		System.out.println(childBird.name);
		System.out.println(bird.name);
	}
}
class Bird extends Animal{
	String eat;
	String name="鸟类";
//	public void run(){
//		System.out.println("飞翔-------------");
//	}
}
class ChildBird extends Bird{
	String name="小鸟";
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