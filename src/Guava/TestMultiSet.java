package Guava;

import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * 
 * 描述：分拣存储,
 * Set:普通的Set是不可重复的
 * Multiset:是可以重复的的，无序
 * @author gt
 * @created 2016年3月17日 下午4:08:45
 * @since
 */
public class TestMultiSet {
  public static void main(String[] args) {
	String str = "this is good student he is good good child";
	String[] strarray = str.split(" "); 
	Multiset<String> multiset = HashMultiset.create();
	for (String string : strarray) {
		multiset.add(string);
	}
	for (String string : multiset) {
		System.out.println(string+"===="+multiset.count(string));
	}
	System.out.println("==========转换成普通的Set容器=============");
	//遍历单词，这是转换会普通的Set因为之前的那个是有重复的
	Set<String> set = multiset.elementSet();
	for (String string : set) {
		System.out.println(string+"===="+multiset.count(string));
	}
  }
}
