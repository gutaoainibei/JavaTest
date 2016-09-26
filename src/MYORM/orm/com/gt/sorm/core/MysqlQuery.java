package MYORM.orm.com.gt.sorm.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import MYORM.orm.com.gt.sorm.bean.TableInfo;
import MYORM.orm.com.gt.sorm.po.Address;
import MYORM.orm.com.gt.sorm.utils.JDBCUtils;
import MYORM.orm.com.gt.sorm.utils.ReflectUtils;

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

	}

	@Override
	public void delete(Class clazz, Object id) {
          Map<Class, TableInfo> map = TableContext.persistClassToTable;
          TableInfo tableInfo = map.get(clazz);
          String sql = "delete from "+tableInfo.getTname()+" where "+tableInfo.getOnlyPriKey().getName()+" = "+id;
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
	public int update(Object object, String[] fieldNames) {
		return 0;
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
		query.delete(address);
	}
}
