package MYORM.orm.com.gt.sorm.core;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import oracle.net.aso.p;
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
	public static Map<String, TableInfo> tables = new HashMap<String,TableInfo>();
	//保存所有对象合表对应的数据
	public static Map<Class, TableInfo> persistClassToTable = new HashMap<Class,TableInfo>();
	static{
		try {
//			Connection connection = DBManager.getConnection();
//			//获取表的元数据
//			DatabaseMetaData metaData = connection.getMetaData();
//			String catalog：要获得表所在的编目。"“”"意味着没有任何编目，Null表示所有编目。
//		    String schema：要获得表所在的模式。"“”"意味着没有任何模式，Null表示所有模式。
//		    String tableName：指出要返回表名与该参数匹配的那些表，
//		    String types：一个指出返回何种表的数组。
//			//"%" means match any substring of 0 or more characters, and "_" means match any one character
//	        //types有"TABLE"、"VIEW"、"SYSTEM TABLE"， "GLOBAL TEMPORARY"，"LOCAL  TEMPORARY"，"ALIAS"，"SYSNONYM"
			Connection conn = DBManager.getConnection();
			DatabaseMetaData metaData = conn.getMetaData();
			System.out.println("产品名称："+metaData.getDatabaseProductName());
			System.out.println("产品版本："+metaData.getDatabaseProductVersion());
			System.out.println("驱动名称："+metaData.getDriverName());
			System.out.println("驱动版本："+metaData.getDriverVersion());
			System.out.println("当前数据库的类型信息："+metaData.getTypeInfo());
			//  通过getTables（）方法返回的结果集中的每个表都有下面是10字段的描述信息，
			//  而且只有10个。通常我们用到的也就是标红的几个字段。
			//而且在结果集中直接使用下面字段前面的序号即可获取字段值。
//			1.TABLE_CAT        (String)   => 表所在的编目(可能为空)  
//          2.TABLE_SCHEM (String)   => 表所在的模式(可能为空)  
//          3.TABLE_NAME    (String)   => 表的名称
//          4.TABLE_TYPE     (String)    => 表的类型。
//            典型的有 "TABLE", "VIEW", "SYSTEM TABLE", "GLOBAL TEMPORARY", "LOCAL  TEMPORARY", "ALIAS", "SYNONYM". 
//          5.REMARKS          (String)       => 解释性的备注
//          6.TYPE_CAT          (String)      =>编目类型(may be null) 
//          7.TYPE_SCHEM   (String)      => 模式类型(may be null) 
//          8.TYPE_NAME      (String)      => 类型名称(may be null) 
//          9.SELF_REFERENCING_COL_NAME    (String) => name of the designated "identifier" column of a typed table (may be null) 
//          10.REF_GENERATION   (String)    => specifies how values in SELF_REFERENCING_COL_NAME are created.
//          它的值有："SYSTEM"、"USER"、"DERIVED"，也可能为空。
			ResultSet tableResultSet = metaData.getTables(null, "%", "%", new String[]{"table","SYSTEM TABLE"});
			while (tableResultSet.next()) {
				String tableName = tableResultSet.getString("table_name");
				TableInfo table = new TableInfo(tableName, new HashMap<String, ColumnInfo>(), new ArrayList<ColumnInfo>());
				System.out.println("表名：" + tableName);
				tables.put(tableName, table);
			    ResultSet columns = metaData.getColumns(null, "%", tableName, "%");
			    while (columns.next()) {
			    	  System.out.println("--列名："+columns.getString("column_name"));
                      ColumnInfo columnInfo = new ColumnInfo(columns.getString("column_name"), columns.getString("TYPE_NAME"), 0);			    	
			    	  table.getColumns().put(columns.getString("column_name"), columnInfo);
				}
			    ResultSet priKeys = metaData.getPrimaryKeys(null, "%", tableName);
			    while (priKeys.next()) {
					ColumnInfo columnInfo = table.getColumns().get(priKeys.getString("column_name"));
                    System.out.println("--主键："+columnInfo.getName());
					columnInfo.setKeyType(1);
					table.getPriKeys().add(columnInfo);
			    }
			    if(table.getPriKeys().size() > 0){
			    	table.setOnlyPriKey(table.getPriKeys().get(0));
			    }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println(tables);
	}
}
