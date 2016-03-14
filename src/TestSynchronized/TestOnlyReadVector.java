package TestSynchronized;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * 描述：emptyXxx()空的不可变的集合
 *      singletonXxx()一个元素不可变的集合
 *      unmodifiableXxx()不可变容器
 * @author gt
 * @created 2016年3月14日 下午11:24:23
 * @since
 */
public class TestOnlyReadVector {
     public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "gutao");
		map.put("age", 23);
		Map<String, Object> map1 = Collections.unmodifiableMap(map);
		//这里是可以改变的
		//map1.put("address", "江苏");
		//System.out.println(map1.get("name"));
		List<String> list = Collections.singletonList(new String("gutao"));
		//list.add("nibei");singletonList只能存一个 
	    System.out.println(list.get(0));
	    
     }
     public static Set<String> operation(Set<String> set){
    	 while(null==set){
    		 return Collections.EMPTY_SET;//这样就不会反悔空值了
    	 }
    	 return set;
     }
}
