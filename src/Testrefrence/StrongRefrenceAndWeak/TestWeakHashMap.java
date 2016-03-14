package Testrefrence.StrongRefrenceAndWeak;

import java.util.WeakHashMap;

/**
 * 
 * 描述：这是测试WeakHashMap的键值为弱引用
 * @author gt
 * @created 2016年3月14日 下午3:54:40
 * @since
 */
public class TestWeakHashMap {
    public static void main(String[] args) {
		WeakHashMap<String, Object> weakHashMap = new WeakHashMap<String, Object>();
		weakHashMap.put("name", "gutao");
		weakHashMap.put("age", 23);
		weakHashMap.put(new String("address"), "江苏省淮安市");
		System.out.println("gc运行前："+weakHashMap.size());
		System.gc();
		System.runFinalization();
	    System.out.println("gc运行后："+weakHashMap.size());
	}
}
