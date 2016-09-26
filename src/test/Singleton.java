package test;

public class Singleton {

    public String name = "gutao";
	public String getName() {
		System.out.println(this);
		this.tt();
		return this.name;
	}
    
	public Singleton() {
		super();
		System.out.println("父类");
	}

	public void setName(String name) {
		this.name = name;
	}
    public void tt(){
    	System.out.println("父类的tt方法");
    }
	@Override
	public String toString() {
		return "父类Singleton";
	}
	
}
