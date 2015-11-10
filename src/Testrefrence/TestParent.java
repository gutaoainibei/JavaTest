package Testrefrence;

import org.springframework.beans.BeanUtils;

public class TestParent {
 public static void main(String[] args) {
	 TestChild1 t = new TestChild1(); 
	 TestChild2 t2 = new TestChild2();
	 BeanUtils.copyProperties(t, t2);
	 System.out.println("age: "+t.age+",name: "+t.name);
	 System.out.println("age: "+t2.age+",name: "+t2.name+",id: "+t2.id);
}
}
class TestParent1{
	
	public TestParent1(){
		System.out.println("父类");
	}
	
}
class TestChild1 extends TestParent1{
	public int age = 20;
	public String name="gutao";
	public TestChild1(){
		System.out.println("子类");
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
class TestChild2{
	public int age = 0;
	public String name="gt";
	public int id = 4;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	} 
	
}
