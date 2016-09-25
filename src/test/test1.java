package test;
class Singleton{
	

	public String name;

	public String getName() {
		System.out.println("--------------");
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
public class test1 extends Singleton{

	
	public static void main(String[] args) {
		test1  test= new test1(); 
		test.setName("JDK");
		System.out.println(test.name);
	

	
	}

}


