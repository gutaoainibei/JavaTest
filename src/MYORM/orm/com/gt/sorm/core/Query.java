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
 * 描述：
 * @author gt
 * @created 2016年8月24日 下午7:33:21
 * @since
 */
public abstract class Query implements Cloneable{
	/**
	 * 
	* @Title: queryTemplete 
	* @Description: TODO(查询模板) 
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
	   * 
	   * 描述：执行sql语句
	   * @author gt
	   * @created 2016年8月24日 下午7:38:19
	   * @since 
	   * @param sql sql语句
	   * @param params 参数
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
       * 
       * 描述：插入数据，存储一个对象
       * @author gt
       * @created 2016年8月24日 下午7:41:30
       * @since 
       * @param object
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
       * 
       * 描述：按照id删除一个对象
       * @author gt
       * @created 2016年8月30日 下午10:20:15
       * @since 
       * @param clazz 和表对应的class对象
       * @param id 主键id
       */
      public void delete(Class clazz,Object id){
    	  Map<Class, TableInfo> map = TableContext.persistClassToTable;
          TableInfo tableInfo = map.get(clazz);
          String sql = "delete from "+tableInfo.getTname()+" where "+tableInfo.getOnlyPriKey().getName()+" = ?";
          executeSql(sql,new Object[]{id});
      }
      /**
       * 
       * 描述：删除对象
       * @author gt
       * @created 2016年8月30日 下午10:24:23
       * @since 
       * @param object
       */
      public void delete(Object object){
    	  Class clazz = object.getClass();
          TableInfo tableInfo = TableContext.persistClassToTable.get(clazz);
          String primaryKey = tableInfo.getOnlyPriKey().getName();
          Object obj = ReflectUtils.getMethodRetunValue(object, primaryKey);
          delete(clazz, obj);
      }
      /**
       * 
       * 描述：直接更新传入对象
       * @author gt
       * @created 2016年9月27日 下午2:07:13
       * @since 
       * @param object
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
       * 
       * 描述：更新对象，按照要求的列
       * @author gt
       * @created 2016年8月30日 下午10:28:14
       * @since 
       * @param object
       * @param fieldNames
       * @return
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
      }//update *** set name = ?,password = ?
      /**
       * 
       * 描述：条件查询，返回结果集
       * @author gt
       * @created 2016年8月30日 下午10:33:30
       * @since 
       * @param sql
       * @param clazz
       * @param params
       * @return
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
       * 
       * 描述：返回一行
       * @author gt
       * @created 2016年8月30日 下午10:36:02
       * @since 
       * @param sql
       * @param clazz 用于封装对象
       * @param params
       * @return
       */
      public Object queryUniqueRow(String sql , Class clazz , Object[] params){
    	  List list = queryRows(sql, clazz, params);
  		  return (list != null && list.size()>0) ? list.get(0) : null;
      }
      /**
       * 
       * 描述：获取一行一直
       * @author gt
       * @created 2016年8月30日 下午10:38:09
       * @since 
       * @param sql
       * @param params
       * @return
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
       * 
       * 描述：获取一行一列的值（数字）
       * @author gt
       * @created 2016年8月30日 下午10:42:32
       * @since 
       * @param sql
       * @param params
       * @return
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
