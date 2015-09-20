package testInterfaceorAbstract;

public class Test1 extends TestDoorAbstract {

	@Override
	void fun() {
		// TODO Auto-generated method stub
       System.out.println("TestDoorAbstract");
	}
    public static void main(String[] args) {
		System.out.println(name);
		Test1 test1 =new Test1();
		test1.setName("gutao");
		System.out.println(test1.getName());
	}
}
