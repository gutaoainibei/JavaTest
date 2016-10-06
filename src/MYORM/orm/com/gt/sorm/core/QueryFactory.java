package MYORM.orm.com.gt.sorm.core;


/**
 * 
* @ClassName: QueryFactory 
* @Description: TODO(创建query的工厂类) 
* @author gutao 
* @date 2016年10月6日 上午11:31:33 
*
 */
public class QueryFactory {
	/**
	 * 查询类对象
	 */
      private static Query query;
      static{
    	  try {
			Class clazz = Class.forName(DBManager.getConfig().getQueryClass());
    	    query = (Query) clazz.newInstance();
    	  } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
      }
      private QueryFactory(){
      }
      public static Query createQuery(){
    	  try {
			return (Query) query.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
      }
 
}
