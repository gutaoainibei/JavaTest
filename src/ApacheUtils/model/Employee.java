package ApacheUtils.model;

/**
 * 
 * 描述：员工模型类
 * 
 * @author gt
 * @created 2016年3月21日 下午8:04:16
 * @since
 */
public class Employee {
	private String name;
	private double salary;

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

	@Override
	public String toString() {
		return "Employee [姓名=" + name + ", 薪资=" + salary + "]";
	}
    
}
