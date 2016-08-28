package MYORM.orm.com.gt.sorm.core;
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
       * 描述：插入数据
       * @author gt
       * @created 2016年8月24日 下午7:41:30
       * @since 
       * @param object
       */
      public void insert(Object object);
}
