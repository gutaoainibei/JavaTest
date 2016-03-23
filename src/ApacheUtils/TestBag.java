package ApacheUtils;


import java.util.Iterator;
import java.util.Set;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bag.TreeBag;

/**
 * 
 * 描述：bag，有序TreeBag
 *          无序HashBag
 * @author gt
 * @created 2016年3月23日 下午8:17:59
 * @since
 */
public class TestBag {
   public static void main(String[] args) {
		String str = "this is good student he is good good child";
		String[] strarray = str.split(" "); 
		Bag<String> bag = new TreeBag<String>();
		for (String string : strarray) {
			bag.add(string);
		}
		Set<String> setkeys = bag.uniqueSet();
		for (String string : setkeys) {
			System.out.println(string+"-->"+bag.getCount(string));
		}
   }
   public static void testTreeBag(){
	   System.out.println("======有序bag=======");
	   Bag<String> bag = new TreeBag<String>();
	   bag.add("gutao");
	   bag.add("nibei",3);
	   bag.add("luoming",2);
	   bag.remove("nibei",1);
	   Iterator<String> iterator = bag.iterator();
	   while (iterator.hasNext()) {
			System.out.println(iterator.next());
	   }
   }
   /**
    * 
    * 描述：测试无序bag
    * @author gt
    * @created 2016年3月23日 下午8:23:30
    * @since
    */
   public static void testHashBag(){
	   System.out.println("=======无序bag======");
	   Bag<String> bag = new HashBag<String>();
		bag.add("gutao");
		bag.add("nibei",3);
		bag.add("luoming",2);
		bag.remove("nibei",1);
		Iterator<String> iterator = bag.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
   }   
}
