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
import MYORM.orm.com.gt.sorm.po.Address;
import MYORM.orm.com.gt.sorm.utils.JDBCUtils;
import MYORM.orm.com.gt.sorm.utils.ReflectUtils;
/**
 * 
 * 描述：
 * @author gt
 * @created 2016年9月29日 上午9:37:39
 * @since
 */
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
		    TableInfo tableInfo = TableContext.persistClassToTable.get(clazz);
		    List<Object> params = new ArrayList<Object>();
		    StringBuffer sql = new StringBuffer("insert into "+tableInfo.getTname()+"(");
		    Field[] fieldNames = clazz.getDeclaredFields();
		    int count = 0;
		    for (Field field : fieldNames) {
		    	String colunmnName = field.getName();
			    Object fieldValue = ReflectUtils.getMethodRetunValue(object, colunmnName);
			    if(fieldValue != null){
			    	 sql.append(colunmnName+","); 
			    	 count++;
			    	 params.add(fieldValue);
			    }
			}
		    sql.setCharAt(sql.length()-1, ')');
		    sql.append(" values (");
		    for (int i = 0;i < count; i++) {
				sql.append("?,");
			}
		    sql.setCharAt(sql.length()-1, ')');
		    if (count > 0) {
		    	executeSql(sql.toString(), params.toArray());
			}
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
	    if (count > 0) {
	      executeSql(sql.toString(), params.toArray());
	    }
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
		Connection conn = DBManager.getConnection();
		List list = null;
		PreparedStatement psmt = null;
		try {
			psmt = conn.prepareStatement(sql);
			JDBCUtils.handleParamers(psmt, params);
			ResultSet rs = psmt.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			while (rs.next()) {
				if(list == null){
					list = new ArrayList();
				}
				Object object = clazz.newInstance();
				for (int i = 0; i < metaData.getColumnCount(); i++) {
					String columnName = metaData.getColumnLabel(i+1);
					Object objValue = rs.getObject(i+1);
					ReflectUtils.setMethodSetValue(object, columnName, objValue);
				}
				list.add(object);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally{
			DBManager.close(psmt, conn);
		}
		return list;
	}

	@Override
	public Object queryUniqueRow(String sql, Class clazz, Object[] params) {
		List list = queryRows(sql, clazz, params);
		return list == null ? null : list.get(0);
	}
	@Override
	public Object getValue(String sql, Object[] params) {
		Connection conn = DBManager.getConnection();
		Object obj = null;
		PreparedStatement psmt = null;
		try {
			psmt = conn.prepareStatement(sql);
			JDBCUtils.handleParamers(psmt, params);
			ResultSet rs = psmt.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			while (rs.next()) {
				obj = rs.getObject(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBManager.close(psmt, conn);
		}
		return obj;
	}

	@Override
	public Number queryNumber(String sql, Object[] params) {
		Number num = (Number)getValue(sql, params);
		return num;
	}
    public static void main(String[] args) {
		MysqlQuery query = new MysqlQuery();
//		query.delete(Address.class, "1");
		Address address = new Address();
//		address.setId(5);
//		address.setAddress("顾涛");
//		address.setCreate_time(commonUtils.getToday());
//		address.setUpdate_time(commonUtils.getToday());
//		query.update(address, new String[]{"address","create_time"});
//		query.delete(address);
//		query.update(address);
//		query.insert(address);
//		List<Address> list = query.queryRows("select * from address where id = ?", Address.class, new Object[]{1});
//		for (Address address2 : list) {
//			System.out.println(address2.getId()+","+address2.getAddress()+","+address2.getCreate_time()+","+address2.getUpdate_time());
//		}
		Address address2= (Address) query.queryUniqueRow("select * from address where id = 5", Address.class, null);
		System.out.println(address2);
//		System.out.println(address2.getId()+","+address2.getAddress()+","+address2.getCreate_time()+","+address2.getUpdate_time());
//        Object name = query.queryNumber("select count(*) from address ", null);
//        System.out.println(name);
    }
	
}
