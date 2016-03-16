package Guava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import com.google.common.collect.ImmutableList;

/**
 * 
 * 描述：只读的设置
 * @author gt
 * @created 2016年3月15日 下午11:16:06
 * @since
 */
public class Test1ImmutableList {
   public static void main(String[] args) {
	List<String> list = new ArrayList<String>();
	list.add("gutao");
	list.add("nibei");
	list.add("gutaoainibei");
	//这里readList是不可以更改的，相当于原来list的一个视图或者说是快照
	List<String> readList = Collections.unmodifiableList(list);
	//readList.add("test");//这里是不能添加的
	list.add("test");//视图会跟着添加
	System.out.println(readList.get(3));
	//与下面的进行对比
	//这里返回的直接是一个不可以改变的list
	List<String>  immutableList = ImmutableList.of("gutao","nibei","gutaoainibei");
	//immutableList.add("test");//这里会直接报错
	System.out.println(immutableList.get(0));
}
}
