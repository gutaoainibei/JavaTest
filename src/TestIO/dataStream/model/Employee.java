package TestIO.dataStream.model;

import java.io.Serializable;

/**
 * 
 * 描述：进行序列化
 * 
 * @author gt
 * @created 2016年3月31日 上午12:46:12
 * @since
 */
public class Employee implements Serializable {
	// 无需序列化，用transient修饰
	private transient String name;
	private double salary;

	public Employee() {
	}

	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
