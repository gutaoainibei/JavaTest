package collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestCollection {
    public static void main(String[] args) {
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
