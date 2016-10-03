package MYORM.orm.com.gt.sorm.core;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import MYORM.orm.com.gt.sorm.bean.TableInfo;
import MYORM.orm.com.gt.sorm.po.Product;
import MYORM.orm.com.gt.sorm.utils.JDBCUtils;
import MYORM.orm.com.gt.sorm.utils.ReflectUtils;
import MYORM.orm.com.gt.sorm.utils.commonUtils;
/**
 * 
 * 描述：
 * @author gt
 * @created 2016年9月29日 上午9:37:39
 * @since
 */
public class MysqlQuery extends Query {
    Logger logger = Logger.getLogger(MysqlQuery.class);
	
    public static void main(String[] args) {
		MysqlQuery query = new MysqlQuery();
		Product product = new Product();
//		query.delete(Address.class, "1");
		product.setId(5);
//		product.setAddress("美国");
//		product.setCounts(1000);
//		product.setName("顾涛");
//		query.update(product, new String[]{"address","name"});
		query.delete(product);
//		query.update(product);
//		query.insert(product);
//		List<Product> list = query.queryRows("select * from product", Product.class, null);
//		for (Product product : list) {
//			System.out.println(product.getId()+","+product.getAddress()+","+product.getName()+","+product.getCounts());
//		}
//		Address address2= (Address) query.queryUniqueRow("select * from address where id = 5", Address.class, null);
//		System.out.println(address2);
//		System.out.println(address2.getId()+","+address2.getAddress()+","+address2.getCreate_time()+","+address2.getUpdate_time());
//        Object name = query.queryNumber("select count(*) from address ", null);
//        System.out.println(name);
    }
	
}
