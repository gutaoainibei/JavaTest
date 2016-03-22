package ApacheUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;

/**
 * 
 * 描述：用apache的CollectionUtils取交集，并集，差集
 * @author gt
 * @created 2016年3月22日 下午11:27:15
 * @since
 */
public class TestCollectionUtils {
    public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		Set<Integer> set2 = new HashSet<Integer>();
		set2.add(2);
		set2.add(3);
		set2.add(4);
		System.out.println("并集为：");
		Collection<Integer> unionCollection = CollectionUtils.union(set1, set2);
		for (Integer integer : unionCollection) {
			System.out.print(integer+" ");
		}
		System.out.println();
		System.out.println("交集为：");
		//这是两种写法
		//Collection<Integer> interCollection = CollectionUtils.retainAll(set1, set2);
		Collection<Integer> interCollection = CollectionUtils.intersection(set1, set2);

		for (Integer integer : interCollection) {
			System.out.print(integer+" ");
		}
		System.out.println();
		System.out.println("差集为：");
		Collection<Integer> diffCollection = CollectionUtils.subtract(set1, set2);
		for (Integer integer : diffCollection) {
			System.out.print(integer+" ");
		}
	}
}
