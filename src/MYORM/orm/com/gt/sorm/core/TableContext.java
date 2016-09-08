package MYORM.orm.com.gt.sorm.core;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import MYORM.orm.com.gt.sorm.bean.ColumnInfo;
import MYORM.orm.com.gt.sorm.bean.TableInfo;
/**
 * 
 * 描述：表信息
 * @author gt
 * @created 2016年9月4日 上午10:35:14
 * @since
 */
public class TableContext {
	//保存所有表名合表信息
	private static Map<String, TableInfo> tables = new HashMap<String,TableInfo>();
	//保存所有对象合表对应的数据
	private static Map<Class, TableInfo> persistClassToTable = new HashMap<Class,TableInfo>();
    
	static{
		try {
			Connection connection = DBManager.getConnection();
			//获取表的元数据
			DatabaseMetaData metaData = connection.getMetaData();
			
//			String catalog：要获得表所在的编目。"“”"意味着没有任何编目，Null表示所有编目。
//		    String schema：要获得表所在的模式。"“”"意味着没有任何模式，Null表示所有模式。
//		    String tableName：指出要返回表名与该参数匹配的那些表，
//		    String types：一个指出返回何种表的数组。
			ResultSet tableSet = metaData.getTables(null, null, null, new String[]{"table"});
		   while (tableSet.next()) {
			    System.out.println(tableSet.getObject("table_name"));
			    String tableName = (String)tableSet.getObject("table_name");
			    TableInfo ti = new TableInfo(tableName, new HashMap<String,ColumnInfo>(), new ArrayList<ColumnInfo>());
		        tables.put(tableName, ti);
		        ResultSet columnset = metaData.getColumns(null, "%", tableName, "%"); 
		        while (columnset.next()) {
					ColumnInfo columnInfo = new ColumnInfo(columnset.getString("COLUMN_NAME"),columnset.getString("TYPE_NAME"),0);
				    ti.getColumns().put(columnset.getString("COLUMN_NAME"), columnInfo);
		        }
		        ResultSet result2 = metaData.getPrimaryKeys(null, "%", tableName);
		        while (result2.next()) {
					ColumnInfo ci2 = (ColumnInfo)ti.getColumns().get(result2.getObject("COLUMN_NAME"));
				    ci2.setKeyType(1);
				    ti.getPriKeys().add(ci2);
		        }
		        if (ti.getPriKeys().size() > 0) {
					ti.setOnlyPriKey(ti.getPriKeys().get(0));
				}
		   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println("gutao");
	}
}
