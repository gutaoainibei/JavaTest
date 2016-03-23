package ApacheUtils;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.collections4.bidimap.DualTreeBidiMap;

/**
 * 
 * 描述：双向map
 * @author gt
 * @created 2016年3月23日 下午7:53:14
 * @since
 */
public class TestBidimap {
   public static void main(String[] args) {
	   testDualTreeBidiMap();
   }
   public static void testDualTreeBidiMap(){
	   System.out.println("=======有序双向map========");
		BidiMap<String, String> bidiMap = new DualTreeBidiMap<String, String>();
		bidiMap.put("gutao", "gutaoai@126.com");
		bidiMap.put("nibei", "nibei@123.com");
		//键和值都唯一
		//bidiMap.put("gutao1", "nibei@123.com");//这里重复之后会覆盖,值和键都有效
		//bidiMap.put("gutao", "nibei@123.com");//这里重复之后会覆盖,值和键都有效
		System.out.println(bidiMap.inverseBidiMap());
		MapIterator<String, String> mapIterator = bidiMap.mapIterator();
	    while(mapIterator.hasNext()){
	    	System.out.println(mapIterator.next()+"="+mapIterator.getValue());
	    }
   }
   public static void testDualHashBidiMap(){
	    System.out.println("=======无序双向map========");
		BidiMap<String, String> bidiMap = new DualHashBidiMap<String, String>();
		bidiMap.put("gutao", "gutaoai@126.com");
		bidiMap.put("nibei", "nibei@123.com");
		System.out.println(bidiMap.inverseBidiMap());
		MapIterator<String, String> mapIterator = bidiMap.mapIterator();
	    while(mapIterator.hasNext()){
	    	System.out.println(mapIterator.next()+"="+mapIterator.getValue());
	    }
   }
}
