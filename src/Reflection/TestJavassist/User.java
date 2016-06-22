package Reflection.TestJavassist;

public class User {
	private String id;
	public String name;
	protected String address;

	public User() {
	}

	public User(String id, String name, String address) {
		this();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private void test() {
		System.out.println("test insert class code in order to dynamic language");
	}
}
