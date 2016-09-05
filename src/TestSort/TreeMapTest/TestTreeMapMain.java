package TestSort.TreeMapTest;

import java.util.Comparator;
import java.util.TreeMap;

public class TestTreeMapMain {
    public static void main(String[] args) {
		TreeMap<Worker, Object> treeMap = new TreeMap<Worker, Object>();
		Worker w1 = new Worker("gutao", 1000);
		Worker w2 = new Worker("nibei", 500);
	    Worker w3 = new Worker("luoming", 400);
	    treeMap.put(w1, "gt");
	    treeMap.put(w2, "gt");
	    treeMap.put(w3, "gt");
        System.out.println(treeMap.entrySet());
		TreeMap<Person,Object>  treeMap1 = new TreeMap<Person, Object>(new Comparator<Person>() {
			public int compare(Person o1, Person o2) {
				return o1.getIndex()-o2.getIndex();
			}
			
		});
		Person p1 = new Person("gutao", 1000);
		Person p2 = new Person("nibei", 500);
	    Person p3 = new Person("luoming", 4020);
	    treeMap1.put(p1, "nb");
	    treeMap1.put(p2, "nb");
	    treeMap1.put(p3, "nb");
	    System.out.println(treeMap1.entrySet());

	}
}
