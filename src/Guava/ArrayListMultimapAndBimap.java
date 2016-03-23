package Guava;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Multimap;
/**
 * 
 * 描述：Multimap一个键多个值，可以用来统计课表之类的东西（键唯一，值可以多个（可以重复值））
 *      Bimap 双向map键和值都不能重复
 * @author gt
 * @created 2016年3月17日 下午7:11:33
 * @since
 */
public class ArrayListMultimapAndBimap {
    public static void main(String[] args) {
		  testBiMap();
	}
    /**
     * 
     * 描述：测试双向map的应用
     * @author gt
     * @created 2016年3月18日 上午11:25:48
     * @since
     */
    public static void testBiMap(){
    	BiMap<String, String> biMap = HashBiMap.create();
		biMap.put("gutao", "gutaoai@126.com");
		biMap.put("nibei", "nibeiai@126.com");
		//biMap.put("nibei", "nibeiai@12.com");

		System.out.println(biMap.inverse().get("gutaoai@126.com"));
		System.out.println(biMap);
		System.out.println(biMap.inverse().inverse() == biMap);
    }
    //测试Multimap的应用，一键多值
    public static void testMultiMap(){
    	Map<String,String> map = new HashMap<String, String>();
		map.put("数学", "gutao");
		map.put("英语", "倪贝");
		map.put("语文", "倪贝");
		map.put("思想品格", "倪贝");
		map.put("体育", "罗明");
		map.put("美术", "gutao");
		Multimap<String, String> multimap = com.google.common.collect.ArrayListMultimap.create();
		Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, String> entry = iterator.next();
			String keyString = entry.getKey();
			String valueString  = entry.getValue();
			multimap.put(valueString, keyString);
		}
		multimap.put("gutao", "数学");
		Iterator<String> iterator2 = multimap.keySet().iterator();
		while (iterator2.hasNext()) {
           String string = iterator2.next();
           System.out.println(string+"教授："+multimap.get(string));
		}
    }
}
