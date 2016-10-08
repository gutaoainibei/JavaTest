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
import MYORM.orm.com.gt.sorm.bean.TableInfo;
import MYORM.orm.com.gt.sorm.utils.JDBCUtils;
import MYORM.orm.com.gt.sorm.utils.ReflectUtils;

/**
 * 
* @ClassName: Query 
* @Description: 数据库操作父类 
* @author gutao 
* @date 2016年10月8日 下午1:14:00 
*
 */
public abstract class Query implements Cloneable{
	/**
	 * 
	* @Title: queryTemplete 
	* @Description: 查询模板 
	* @param @param sql       sql语句
	* @param @param clazz     查询表对应的class
	* @param @param params    参数
	* @param @param callBack  回掉方法
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	public Object queryTemplete(String sql , Class clazz , Object[] params,CallBack callBack){
		Connection conn = DBManager.getConnection();
  		PreparedStatement psmt = null;
  		try {
  			psmt = conn.prepareStatement(sql);
  			JDBCUtils.handleParamers(psmt, params);
  			ResultSet rs = psmt.executeQuery();
  			return callBack.doExecute(clazz,rs);
  		} catch (SQLException e) {
  			e.printStackTrace();
  			return null;
  		}finally{
  			DBManager.close(psmt, conn);
  		}
	}
	 /**
	 * @Title: executeSql 
	 * @Description: sql执行方法
	 * @param @param sql      执行的sql语句
	 * @param @param params   参数
	 * @return void    返回类型 
	 * @throws
	  */
      public  void executeSql(String sql, Object[] params){
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
     /**
	     * @Title: insert 
	     * @Description: 插入数据，存储一个对象 
	     * @param @param object    插入的数据 
	     * @return void    返回类型 
	     * @throws
      */
      public void insert(Object object){
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
      /**
	      * @Title: delete 
	      * @Description: 按照id删除一个对象
	      * @param @param clazz
	      * @param @param id    设定文件 
	      * @return void    返回类型 
	      * @throws
       */
      public void delete(Class clazz,Object id){
    	  Map<Class, TableInfo> map = TableContext.persistClassToTable;
          TableInfo tableInfo = map.get(clazz);
          String sql = "delete from "+tableInfo.getTname()+" where "+tableInfo.getOnlyPriKey().getName()+" = ?";
          executeSql(sql,new Object[]{id});
      }
      /**
          * 
	      * @Title: delete 
	      * @Description: 删除对象 
	      * @param @param object  要删除的对象
	      * @return void    返回类型 
	      * @throws
       */
      public void delete(Object object){
    	  Class clazz = object.getClass();
          TableInfo tableInfo = TableContext.persistClassToTable.get(clazz);
          String primaryKey = tableInfo.getOnlyPriKey().getName();
          Object obj = ReflectUtils.getMethodRetunValue(object, primaryKey);
          delete(clazz, obj);
      }
      /**
	      * @Title: update 
	      * @Description:直接更新传入对象
	      * @param @param object    要更新的对象 
	      * @return void    返回类型 
	      * @throws
       */
      public void update(Object object){
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
      /**
	      * @Title: update 
	      * @Description: 更新对象，按照要求的列 
	      * @param @param object        要更新的对象
	      * @param @param fieldNames    要更新的字段
	      * @return void    返回类型 
	      * @throws
       */
      public void update(Object object , String[] fieldNames){
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
      /**
	      * @Title: queryRows 
	      * @Description: 条件查询，返回结果集
	      * @param 查询sql
	      * @param 查询对应的class
	      * @param 查询参数
	      * @param @return    设定文件 
	      * @return List      返回查询数据
	      * @throws
       */
      public List queryRows(String sql ,final Class clazz , Object[] params){
  		return (List)queryTemplete(sql, clazz, params, new CallBack() {
			@Override
			public Object doExecute(Class clazz, ResultSet rs) {
				List list = new ArrayList();
				ResultSetMetaData metaData;
	  			try {
	  				metaData = rs.getMetaData();
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
				}catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
	  			return list;
			}
		});
      }
      /**
      * @Title: queryUniqueRow 
      * @Description: 查询一行
      * @param 查询sql
      * @param 查询数据对应的class
      * @param 查询的输入参数
      * @param @return    设定文件 
      * @return Object    返回类型 
      * @throws
       */
      public Object queryUniqueRow(String sql , Class clazz , Object[] params){
    	  List list = queryRows(sql, clazz, params);
  		  return (list != null && list.size()>0) ? list.get(0) : null;
      }
      /**
	      * @Title: getValue 
	      * @Description:获取一行一值 
	      * @param @param 执行的sql
	      * @param @param 执行的参数
	      * @param 返回值
	      * @return Object    返回类型 
	      * @throws
       */
      public Object getValue(String sql , Object[] params){
    	  return queryTemplete(sql, null, params, new CallBack() {
    		  Object obj = null;
			@Override
			public Object doExecute(Class clazz, ResultSet rs) {
				try {
					while (rs.next()) {
						obj = rs.getObject(1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return obj;
			}
		});

      }
      /**
	      * @Title: queryNumber 
	      * @Description: 获取一行一列的值（数字） 
	      * @param @param 执行sql
	      * @param @param 输入的参数
	      * @param @return    设定文件 
	      * @return Number    返回数字
	      * @throws
       */
      public Number queryNumber(String sql , Object[] params){
    	  Number num = (Number)getValue(sql, params);
  		  return num;
      }
      @Override
      protected Object clone() throws CloneNotSupportedException {
    	return super.clone();
      }
}
