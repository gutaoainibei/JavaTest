package test;
//class Singleton{
//	
//
//}
public class test1 extends Singleton{
	public String name = "ni";
	public test1(){
		super();
		System.out.println("子类");
	}
	public static void main(String[] args) {
		test1 test= new test1(); 
		System.out.println(test.getName());
	}
	public void tt(){
	    	System.out.println("子类的tt方法");
	}
	@Override
	public String toString() {
		return "子类test1";
	}
    
}


