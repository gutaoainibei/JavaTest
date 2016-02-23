package TestGeneric;

public class Student <T>{
     T name;

	public T getName() {
		return name;
	}

	public void setName(T name) {
		this.name = name;
	}
     
}
