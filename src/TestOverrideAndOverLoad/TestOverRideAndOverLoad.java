package TestOverrideAndOverLoad;

public class TestOverRideAndOverLoad {
	 public void test(){
		 System.out.println("无参数");
	 }
	 public void test(int id){
		 System.out.println("有一个int型的参数");
		 
	 }
	 public void test(int id,String name){
		 System.out.println("有一个int型的参数和一个string型参数，int型在前面");
	 }
	 public void test(double d){
		 System.out.println("有一个double型参数");
	 }
	 public void test(String name,int id){
		 System.out.println("有两个参数，前面的是String");
	 }
     public static void main(String[] args) {
    	 //重载就是参数个数和类型不一样，当两个或有多个参数，参数的顺序不一样也构成重载其实这也属于类型不一样
		TestOverRideAndOverLoad t = new TestOverRideAndOverLoad();
		t.test();
		t.test(1);
		t.test(0.1);
		t.test(0);
		t.test(1, "gutao");
		t.test("gutao", 1);
	}
}

