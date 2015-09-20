package testInterfaceorAbstract;

public abstract class TestDoorAbstract {
	  public static String name="gutao";
      public void test1(){
    	  System.out.println("test1");
      }
      abstract void fun();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	};
      
}
