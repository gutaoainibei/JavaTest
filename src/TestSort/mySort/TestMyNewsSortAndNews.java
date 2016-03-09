package TestSort.mySort;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import TestSort.mySort.Model.News;
import TestSort.mySort.Model.Shop;
import TestSort.mySort.Utils.NewsSortUtils;
import TestSort.mySort.Utils.ShopSortUtils;

public class TestMyNewsSortAndNews {
	public static void main(String[] args) {
      List<News> news = new ArrayList<News>();
      List<Shop> shops = new ArrayList<Shop>();
      News news1 = new News("天天向上", new Date(), 10000);
      News news2 = new News("天天向上", new Date(), 40000);
      News news3 = new News("天天向上", new Date(), 30000);
	  news.add(news1);
	  news.add(news2);
	  news.add(news3);
	  MySortUtil.Sort(news, new NewsSortUtils());
	  for (int i = 0; i < news.size(); i++) {
		System.out.println(news.get(i));
	  }
	  System.out.println("=================================");
	  Shop shop1 = new Shop("湖北省武汉市", "月饼店", 3240);
	  Shop shop2 = new Shop("江苏省南京市", "xaio店", 3240);
	  Shop shop3 = new Shop("广东省深圳市", "小吃店", 323340);
	  shops.add(shop1);
	  shops.add(shop2);
	  shops.add(shop3);
      MySortUtil.Sort(shops, new ShopSortUtils());
      for (int i = 0; i < shops.size(); i++) {
		System.out.println(shops.get(i));
	}
	}
}
