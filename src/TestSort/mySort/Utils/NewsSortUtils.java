package TestSort.mySort.Utils;

import java.util.Comparator;

import TestSort.mySort.Model.News;

public class NewsSortUtils implements Comparator<News>{
   //按照1：点击量
   //   2：创建时间
   //   3：标题来排序
	@Override
	public int compare(News o1, News o2) {
		int result = o1.getCreateTime().compareTo(o2.getCreateTime());
		if(result == 0){
			result = o1.getHits()-o2.getHits();
			if(result == 0){
				result = o1.getTitle().compareTo(o2.getTitle());
			}
		}
		return result ;
	}

}
