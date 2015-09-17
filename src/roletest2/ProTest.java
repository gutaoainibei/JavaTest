package roletest2;

import java.sql.Date;

import roletest1.Animal;

public class ProTest {
	private String name;
	public int age;
	public Date time;
	private String password;
	protected String price;
	protected void nibei() {
		
	}
	private void gutao(){
		
	}
    public static void main(String[] args) {
		Animal animal = new Animal();
		System.out.println(animal.public_name);
	}
    public void test(){
    	System.out.println("test");
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
}
