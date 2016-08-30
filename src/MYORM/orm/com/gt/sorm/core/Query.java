package MYORM.orm.com.gt.sorm.core;

import java.util.List;

/**
 * 
 * 描述：
 * @author gt
 * @created 2016年8月24日 下午7:33:21
 * @since
 */
public interface Query {
	  /**
	   * 
	   * 描述：执行sql语句
	   * @author gt
	   * @created 2016年8月24日 下午7:38:19
	   * @since 
	   * @param sql sql语句
	   * @param params 参数
	   */
      public void executeSql(String sql, Object[] params);
      /**
       * 
       * 描述：插入数据，存储一个对象
       * @author gt
       * @created 2016年8月24日 下午7:41:30
       * @since 
       * @param object
       */
      public void insert(Object object);
      /**
       * 
       * 描述：按照id删除一个对象
       * @author gt
       * @created 2016年8月30日 下午10:20:15
       * @since 
       * @param clazz 和表对应的class对象
       * @param id 主键id
       */
      public void delete(Class clazz,String id);
      /**
       * 
       * 描述：删除对象
       * @author gt
       * @created 2016年8月30日 下午10:24:23
       * @since 
       * @param object
       */
      public void delete(Object object);
      /**
       * 
       * 描述：更新对象
       * @author gt
       * @created 2016年8月30日 下午10:28:14
       * @since 
       * @param object
       * @param fieldNames
       * @return
       */
      public int update(Object object , String[] fieldNames);//update *** set name = ?,password = ?
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
      public List queryRows(String sql , Class clazz , Object[] params);
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
      public Object queryUniqueRow(String sql , Class clazz , Object[] params);
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
      public Object getValue(String sql , Object[] params);
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
      public Number queryNumber(String sql , Object[] params);
}
