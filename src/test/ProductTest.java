package test;

import java.util.Set;

public class ProductTest {
	private String name;
	private int age;
	private Set<String> address;

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

	public Set<String> getAddress() {
		return address;
	}

	public void setAddress(Set<String> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "ProductTest [name=" + name + ", age=" + age + ", address=" + address + "]";
	}

}
