package collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestCollection {
    public static void main(String[] args) {
    	//ArrayList:底层实现是数组:线程不安全，效率高，所以，查询快，修改插入删除慢
    	//LinkedList:底层实现是链表：线程不安全，效率高，所以查询慢，修改插入删除快
    	//Vector:线程安全，效率低
         List list = new ArrayList();
         list.add("aaa");
         list.add(new Date());
         list.add(1234);
         System.out.println(list.size());
         System.out.println(list.isEmpty());
         list.remove(1);
         System.out.println(list.size());
        
	}
}
