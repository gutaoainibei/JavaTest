package TestSort.TreeSetTest;


public class Worker implements Comparable<Worker>{
    private final String name;
    private  int salary;
    public Worker(){
    	name = null;
    }
    public Worker(String name, int index){
    	this.name = name;
    	this.salary = index;
    }
	public String getName() {
		return name;
	}
	public int getIndex() {
		return salary;
	}
	public String toString() {
		return "Person [name=" + name + ", index=" + salary + "]\n";
	}
	public int compareTo(Worker o) {
		return this.salary>o.salary?1:(this.salary==o.salary?0:-1);
	} 
}
