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
      /**
       * 私有构造方法
       */
      private QueryFactory(){
      }
      /**
      * @Title: createQuery 
      * @Description: 创建查询类 
      * @param @return    设定文件 
      * @return Query    返回类型 
      * @throws
       */
      public static Query createQuery(){
    	  try {
			return (Query) query.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
      }
 
}
