package MYORM;


import java.util.List;
import MYORM.orm.com.gt.sorm.core.Query;
import MYORM.orm.com.gt.sorm.core.QueryFactory;
import MYORM.orm.com.gt.sorm.po.Product;

public class TestOrm {
    public static void main(String[] args) {
		Query query = QueryFactory.createQuery();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 2000; i++) {
			List<Product> list = query.queryRows("select * from product", Product.class, null);
			for (Product product : list) {
				System.out.println(product.getId()+","+product.getAddress()+","+product.getName()+","+product.getCounts());
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("用时："+(end-start)+"ms");//用原先的创建连接耗时15407ms,用连接池用时2880ms
//		Object name = query.getValue("select name from product", null);
//		System.out.println(name);
	}
}
