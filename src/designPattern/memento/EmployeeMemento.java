package designPattern.memento;

public class EmployeeMemento {
	private String name;
	private int age;
	private double salary;

	public EmployeeMemento(Employee employee){
		  this.name = employee.getName();
		  this.age = employee.getAge();
		  this.salary = employee.getSalary();

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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
