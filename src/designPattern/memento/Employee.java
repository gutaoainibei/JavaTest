package designPattern.memento;

public class Employee {
	private String name;
	private int age;
	private double salary;
    
	public EmployeeMemento getMenmeto(){
		return new EmployeeMemento(this);
	}
	
	public void recovery(EmployeeMemento memento){
		this.name = memento.getName();
		this.age = memento.getAge();
		this.salary = memento.getSalary();
	}
	public Employee(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
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
