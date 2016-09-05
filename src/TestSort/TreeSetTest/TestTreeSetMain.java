package TestSort.TreeSetTest;

import java.util.Comparator;
import java.util.TreeSet;

import TestSort.TreeMapTest.Person;
import TestSort.TreeMapTest.Worker;

public class TestTreeSetMain {
    public static void main(String[] args) {
		TreeSet<Person> treeSet = new TreeSet<Person>(
				new Comparator<Person>() {
					public int compare(Person o1, Person o2) {
						return o1.getIndex()-o2.getIndex();
					}
					
				});
		Person p1 = new Person("gutao", 1000);
		Person p2 = new Person("nibei", 2000);
		Person p3 = new Person("luoming", 400);
        treeSet.add(p1);
        treeSet.add(p2);
        treeSet.add(p3);
        System.out.println(treeSet);
        System.out.println("=======================");
        TreeSet<Worker> treeSet1 = new TreeSet<Worker>();
        Worker w1 = new Worker("gutao", 1000);
		Worker w2 = new Worker("nibei", 3000);
		Worker w3 = new Worker("luoming", 400);
        treeSet1.add(w1);
        treeSet1.add(w2);
        treeSet1.add(w3);
        //数据添加的时候就进行了排序
        System.out.println(treeSet1);
        w3.setIndex(4000);
        System.out.println(treeSet1);
    }
}
