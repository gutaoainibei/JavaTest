package MYORM.orm.com.gt.sorm.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import MYORM.orm.com.gt.sorm.core.DBManager;

/**
 * 
* @ClassName: DBConnectionPool 
* @Description: TODO(连接池) 
* @author gutao 
* @date 2016年10月6日 下午12:20:39 
*
 */
public class DBConnectionPool {
	/**
	 *连接池
	 */
    private static List<Connection> poolList;
    /**
     * 连接最大池
     */
    private static final Integer maxPoolSize = DBManager.getConfig().getMaxPool();
    /**
     * 最大连接池
     */
    private static final Integer minPoolSize = DBManager.getConfig().getMinPool();
    /**
     * 
    * @Title: initPool 
    * @Description: 初始化连接池 
    * @param     设定文件 
    * @return void    返回类型 
    * @throws
     */
    public DBConnectionPool(){
    	initPool();
    }
    public void initPool(){
    	if(poolList == null){
    		poolList = new ArrayList<Connection>();
    	}
    	while (poolList.size() < minPoolSize) {
    		poolList.add(DBManager.createConnection());
    		System.out.println("连接池数量："+poolList.size());
		}
    }
    /**
    * @Title: close 
    * @Description: 关闭连接（放回到连接池） 
    * @param     设定文件 
    * @return void    返回类型 
    * @throws
     */
    public synchronized void close(Connection connection){
    	if(poolList.size() >= maxPoolSize){
    		try {
    			if(connection != null){
    				connection.close();
    			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}else{
    		poolList.add(connection);
    	}
    }
    public synchronized Connection getConnection(){
        int pool_size = poolList.size()-1;
        if(pool_size < 0){
        	initPool();
        	pool_size = poolList.size() - 1;
        }
        Connection connection = poolList.get(pool_size);
    	poolList.remove(pool_size);
        return connection;
    }
}
