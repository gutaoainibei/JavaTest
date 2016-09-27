package MYORM.orm.com.gt.sorm.core;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import MYORM.orm.com.gt.sorm.bean.TableInfo;
import MYORM.orm.com.gt.sorm.po.Address;
import MYORM.orm.com.gt.sorm.utils.JDBCUtils;
import MYORM.orm.com.gt.sorm.utils.ReflectUtils;
import MYORM.orm.com.gt.sorm.utils.commonUtils;

public class MysqlQuery implements Query {
    Logger logger = Logger.getLogger(MysqlQuery.class);
	@Override
	public void executeSql(String sql, Object[] params) {
		    Connection conn = DBManager.getConnection();
		    PreparedStatement pstm = null;
            try {
				
				pstm  = conn.prepareStatement(sql);
				JDBCUtils.handleParamers(pstm, params);
				pstm.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBManager.close(pstm, conn);
			}
	}
	@Override
	public void insert(Object object) {
		    Class clazz = object.getClass();
		    TableInfo tableInfo = TableContext.tables.get(clazz);
		    List<Object> params = new ArrayList<Object>();
		    StringBuffer sql = new StringBuffer("insert into "+tableInfo.getTname()+"(");
		    Field[] fieldNames = clazz.getDeclaredFields();
		    int count = 0;
		    for (Field field : fieldNames) {
		    	String colunmnName = field.getName();
		    	count++;
				sql.append(colunmnName+",");
			    Object fieldValue = ReflectUtils.getMethodRetunValue(object, colunmnName);
			    params.add(fieldValue);
			}
		    sql.setCharAt(sql.length()-1, ')');
		    sql.append(" values(");
		    for (Object object2 : params) {
				sql.append("?,");
			}
		    sql.setCharAt(sql.length()-1, ')');
		    System.out.println(sql.toString());
//		    executeSql(sql.toString(), params.toArray());
	}

	@Override
	public void delete(Class clazz, Object id) {
          Map<Class, TableInfo> map = TableContext.persistClassToTable;
          TableInfo tableInfo = map.get(clazz);
          String sql = "delete from "+tableInfo.getTname()+" where "+tableInfo.getOnlyPriKey().getName()+" = ?";
          executeSql(sql,new Object[]{id});
	}

	@Override
	public void delete(Object object) {
         Class clazz = object.getClass();
         TableInfo tableInfo = TableContext.persistClassToTable.get(clazz);
         String primaryKey = tableInfo.getOnlyPriKey().getName();
         Object obj = ReflectUtils.getMethodRetunValue(object, primaryKey);
         delete(clazz, obj);
	}

	@Override
	public void update(Object object, String[] fieldNames) {
	    Class clazz = object.getClass();
	    TableInfo tableInfo = TableContext.persistClassToTable.get(clazz);
	    List<Object> params = new ArrayList<Object>();
	    StringBuffer sql = new StringBuffer("update "+tableInfo.getTname()+" set ");
	    int count = 0;
	    for (String colunmnName : fieldNames) {
	    	count++;
			sql.append(colunmnName+" = ? ,");
		    Object fieldValue = ReflectUtils.getMethodRetunValue(object, colunmnName);
		    params.add(fieldValue);
		}
	    sql.setCharAt(sql.length()-1, ' ');
	    String primaryKey = tableInfo.getOnlyPriKey().getName();
	    Object primaryValue = ReflectUtils.getMethodRetunValue(object, primaryKey); 
	    sql.append("where " + primaryKey + "= ?");
	    params.add(primaryValue);
	    System.out.println(sql.toString());
	    executeSql(sql.toString(), params.toArray());
	}
	@Override
	public void update(Object object) {
		 Class clazz = object.getClass();
		 TableInfo tableInfo = TableContext.persistClassToTable.get(clazz);
		 String primaryKey = tableInfo.getOnlyPriKey().getName();
		 List<Object> params = new ArrayList<Object>();
		 StringBuffer sql = new StringBuffer("update "+tableInfo.getTname()+" set ");
		 Field[] fields = clazz.getDeclaredFields();
		 int count = 0;
		 for (Field field : fields) {
			String columnName = field.getName();
			Object obj = ReflectUtils.getMethodRetunValue(object, columnName);
			if(obj != null && !columnName.equals(primaryKey)){
				count++;
				sql.append(columnName+" = ?,");
				params.add(obj);
			}
		}
		 sql.setCharAt(sql.length()-1, ' ');
		 Object primaryValue = ReflectUtils.getMethodRetunValue(object, primaryKey); 
		 sql.append("where " + primaryKey + "= ?");
		 params.add(primaryValue);
		 if(count > 0){
			 executeSql(sql.toString(), params.toArray());
		 }
	}
	@Override
	public List queryRows(String sql, Class clazz, Object[] params) {
		return null;
	}

	@Override
	public Object queryUniqueRow(String sql, Class clazz, Object[] params) {
		return null;
	}

	@Override
	public Object getValue(String sql, Object[] params) {
		return null;
	}

	@Override
	public Number queryNumber(String sql, Object[] params) {
		return null;
	}
    public static void main(String[] args) {
		MysqlQuery query = new MysqlQuery();
//		query.delete(Address.class, "1");
		Address address = new Address();
		address.setId(2);
		address.setAddress("湖北省");
		address.setCreate_time(commonUtils.getToday());
		address.setUpdate_time(commonUtils.getToday());
//		query.update(address, new String[]{"address","create_time"});
//		query.delete(address);
		query.update(address);
	}
}
