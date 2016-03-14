package TestSynchronized;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 
 * 描述：设置线程安全的容器
 * @author gt
 * @created 2016年3月14日 下午11:23:58
 * @since
 */
public class TestSynchronize {
    public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		List<String> list2 = Collections.synchronizedList(list);
		System.out.println("线程安全的list2设置完成");
	}
}
