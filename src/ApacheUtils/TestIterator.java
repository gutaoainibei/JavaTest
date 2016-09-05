package ApacheUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.iterators.ArrayListIterator;
import org.apache.commons.collections4.iterators.FilterIterator;
import org.apache.commons.collections4.iterators.LoopingIterator;
import org.apache.commons.collections4.iterators.UniqueFilterIterator;
import org.apache.commons.collections4.map.HashedMap;

/**
 * 描述：IterableMap,这个要比之前map.EntrySet.Iterator迭代更好,HashedMap
 *      去重过滤器
 *      IterableMap map迭代器
 *      UniqueFilterIterator去重迭代器
 *      ArrayListIterator数组迭代器
 *      FilterIterator自定义迭代器
 *      LoopingIterator循环迭代器
 * @author gt
 * @created 2016年3月23日 下午4:17:33
 * @since
 */
public class TestIterator {
    public static void main(String[] args) {
    	testArraylistIterator();
    }
    public static void testArraylistIterator(){
    	System.out.println("=======数组迭代器======");
    	int[] arr = {1,2,3,4,5};
    	//数组迭代器
    	//Iterator<Integer> iterator = new ArrayListIterator<Integer>(arr);
    	//指定起始索引和结束索引
    	Iterator<Integer> iterator = new ArrayListIterator<Integer>(arr,1,3);
    	while(iterator.hasNext()){
    		System.out.println(iterator.next());
    	}
    }
    public static void testLoopingIterator(){
    	System.out.println("======自定义迭代器======");
    	List<String> list = new ArrayList<String>();
    	list.add("refer");
    	list.add("mom");
    	list.add("nibei");
    
    	Iterator<String> it = new LoopingIterator<String>(list);
    	for (int i = 0; i < 5; i++) {
			System.out.println(it.next());
		}
//    	while(it.hasNext()){//这里会循环输出
//    		System.out.println(it.next());
//    	}
    }
    public static void testCustomFilterIterator(){
    	System.out.println("======自定义迭代器======");
    	List<String> list = new ArrayList<String>();
    	list.add("refer");
    	list.add("mom");
    	list.add("nibei");
    	Predicate<String> predicate = new Predicate<String>() {
			public boolean evaluate(String string) {
				return new StringBuilder(string).reverse().toString().equals(string);
			}
		};
    	Iterator<String> it = new FilterIterator<String>(list.iterator(),predicate);
    	while(it.hasNext()){
    		System.out.println(it.next());
    	}
    }
    public static void testUniqueFilterIterator(){
    	System.out.println("======去重迭代器======");
    	List<String> list = new ArrayList<String>();
    	list.add("gutao");
    	list.add("nibei");
    	list.add("gutao");
    	Iterator<String> it = new UniqueFilterIterator<String>(list.iterator());
    	while(it.hasNext()){
    		System.out.println(it.next());
    	}
    }
     public static void testIterableMap(){
    	System.out.println("======map迭代器=======");
    	IterableMap<String, Object> iterableMap = new HashedMap<String, Object>();
 		iterableMap.put("name1", "gutao");
 		iterableMap.put("name2", "nibei");
 		iterableMap.put("age1", 23);
 		iterableMap.put("age2", 21);
         MapIterator<String, Object> mapIterator = iterableMap.mapIterator();
         while (mapIterator.hasNext()) {
         	String key = mapIterator.next();
         	System.out.println(key+"-->"+mapIterator.getValue());
 		}
     }
}
