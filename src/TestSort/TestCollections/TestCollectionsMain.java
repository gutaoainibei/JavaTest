package TestSort.TestCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollectionsMain {
	public static void main(String[] args) {
       List<Integer> list = new ArrayList<Integer>();
       list.add(1);
       list.add(2);
       list.add(3);
       list.add(4);
       System.out.println(list);
       //反序
       Collections.reverse(list);
	   System.out.println(list);
	   
       List<Integer> list1 = new ArrayList<Integer>();
       for (int i = 0; i < 54; i++) {
		      list1.add(i);
	   }
       //打乱顺序
       Collections.shuffle(list1);
       List<Integer> cards1 = new ArrayList<Integer>();
       List<Integer> cards2 = new ArrayList<Integer>();
       List<Integer> cards3 = new ArrayList<Integer>();
       List<Integer> last = new ArrayList<Integer>();

       for (int i = 0; i < list1.size(); i+=3) {
             cards1.add(list1.get(i));	
             cards2.add(list1.get(i+1));		
             cards3.add(list1.get(i+2));		
	   }
       last.add(list1.get(51));
       last.add(list1.get(52));
       last.add(list1.get(53));
       System.out.println("甲方："+cards1);
       System.out.println("乙方："+cards2);
       System.out.println("丙方："+cards3);
       System.out.println("剩余："+last);
	}
}
