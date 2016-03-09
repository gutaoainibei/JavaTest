package TestSort.TreeMapTest;

public class Person {
    private final String name;
    private int index;
    public Person(){
    	name = null;
    	index = 0;
    }
    public Person(String name, int index){
    	this.name = name;
    	this.index = index;
    }
	public String getName() {
		return name;
	}
	public int getIndex() {
		return index;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", index=" + index + "]\n";
	} 
    
}
