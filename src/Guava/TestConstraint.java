package Guava;

import java.util.Set;

import com.google.common.collect.Sets;

/**
 * 
 * 描述：sets的简单应用,交集，差集，并集
 * @author gt
 * @created 2016年3月17日 上午1:02:23
 * @since
 */
public class TestConstraint {
  public static void main(String[] args) {
    Set<Integer> set1 = Sets.newHashSet(1,2,3,4,5);
    Set<Integer> set2 = Sets.newHashSet(4,5,6,7,8);
    //取交集
    Set<Integer> sets1 = Sets.intersection(set1, set2);
    for (Integer integer : sets1) {
		System.out.print(integer+" ");
	}
    System.out.println();
    //取差集
    Set<Integer> sets2 = Sets.difference(set1, set2);
    for (Integer integer : sets2) {
		System.out.print(integer+" ");
	}
    System.out.println();
    //取并集
    Set<Integer> sets3 = Sets.union(set1, set2);
    for (Integer integer : sets3) {
		System.out.print(integer+" ");
	}

    Set<String> setString1 = Sets.newHashSet("gutao","nibei","gutaoainibei");
    Set<String> setString2 = Sets.newHashSet("gutao1","nibei2","gutaoainibei");
    System.out.println();
    //字符串取交集
    Set<String> setstring1 = Sets.intersection(setString1, setString2);
    for (String string : setstring1) {
		System.out.print(string+" ");

	}
  }
}
