package StudyHashTableAndHashMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;


/**
 * 
 * 描述：这里来test一下hashtable的子类和说明一下hashmap和hashtable的区别
 * 1.扼要:hashtable线程安全，同步，效率相对较低
 *        haspmap线程非安全，非同步，效率相对较高
 * 2.hashtable的父类是Dictionary ,hashmap是AbstractMap
 * 3.hashtable键和值都不能为空
 *   hashMap的键可以有一个为空，值可以有多个为空
 * 二.这里我们来熟悉一下hashTable的子类   
 * 1.作用：读写资源配置文件
 * 2.键与值只能为字符串
 * 3：常用方法：
 * setProperty(String key,String value);
 * getProperty(String key,String defaultValue);
 * 后缀为.properties
 * store(OutputStream out,String comments);
 * store(Writer writer,String comments);
 * 后缀为.xml
 * storeToXML(OutputStream out,String comments);UTF-8字符集
 * storeToXML(OutputStream out,String comments,String encoding);
 * @author gt
 * @created 2016年3月13日 下午7:06:24
 * @since
 */
public class TestProperties {
	public static void main(String[] args) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//这里看上去很普通的东西但是很多东西，很多人都没有弄懂，学java首先要弄清楚refrences
		//这里最好弄清楚为什么map的值会变，而不是死记
		map.put("name", "gutao");
		map.put("age", "23");
		changeMap(map);
		//这里暂时写两种map的遍历
//	    Iterator<Entry<String, Object>> iterator = map.entrySet().iterator();
//	    while (iterator.hasNext()) {
//			Entry<String, Object> entry = iterator.next();
//			System.out.println(entry.getKey()+":"+entry.getValue());
//		}
//	    Set  set = map.keySet();
//	    for (Object object : set) {
//			System.out.println(object+":"+map.get(object));
//		}
	    //开始测试Properties
	    Properties properties = new Properties();
//	    properties.setProperty("name", "gutao");
//	    properties.setProperty("age", "23");
//	    properties.setProperty("address", "湖北省武汉市");
	    //把属性写出，两种方式按照.properties和.xml输出
//	    try {
//			properties.store(new FileOutputStream(new File("d:/gutao.properties")),"测试Properties");
//	        properties.storeToXML(new FileOutputStream(new File("d:/gutao.xml")), "测试xml");	
//	    } catch (FileNotFoundException e) {
//			throw new Exception("文件输出失败");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	    //这里是加载当前类所在位置路径下的配置文件
	    properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("StudyHashTableAndHashMap/gutao.properties"));
	    System.out.println("name:"+properties.get("name"));
	}
	public static void changeMap(Map map){
		map.put("address", "江苏省淮安市");
	}
}
