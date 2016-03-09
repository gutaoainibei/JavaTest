package TestSort.mySort.Utils;

import java.util.Comparator;

import TestSort.mySort.Model.News;
import TestSort.mySort.Model.Shop;

public class ShopSortUtils implements Comparator<Shop>{
	   //按照1：销售额
	   //   2：地址
	   //   3：名称
	@Override
	public int compare(Shop o1, Shop o2) {
		int result = o1.getSoles_Volume() - o2.getSoles_Volume();
		if(result == 0){
			result = o1.getAddress().compareTo(o2.getAddress());
			if(result == 0){
				result = o1.getName().compareTo(o2.getName());
			}
		}
		return result ;
	}

}
