package MYORM.orm.com.gt.sorm.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import MYORM.orm.com.gt.sorm.bean.Configuration;
import MYORM.orm.com.gt.sorm.pool.DBConnectionPool;
public class DBManager {
	/**
	 * 配置文件的bean
	 */
    private static Configuration configutation;
    private static DBConnectionPool pool;
    static{
    	Properties properties = new Properties();
    	try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		    configutation = new Configuration();
		    configutation.setDriver(properties.getProperty("driver"));
		    configutation.setUrl(properties.getProperty("url"));
		    configutation.setUser(properties.getProperty("username"));
		    configutation.setPassword(properties.getProperty("password"));
		    configutation.setSrcPath(properties.getProperty("srcPath"));
		    configutation.setPackagePath(properties.getProperty("packagePath"));
		    configutation.setUsingDB(properties.getProperty("usingDB"));
		    configutation.setQueryClass(properties.getProperty("queryClass"));
		    configutation.setMinPool(Integer.parseInt(properties.getProperty("minPool")));
		    configutation.setMaxPool(Integer.parseInt(properties.getProperty("maxPool")));
    	    System.out.println(TableContext.class);
    	    pool = new DBConnectionPool();
    	} catch (IOException e) {
			e.printStackTrace();
		}

    }
    /**
     * 
     * 描述：获取连接
     * @author gt
     * @created 2016年8月18日 下午11:19:55
     * @since 
     * @return
     */
    public static Connection getConnection(){
   	    return pool.getConnection();
    }
    /**
     * 
     * 描述：创建连接
     * @author gt
     * @created 2016年8月18日 下午11:19:55
     * @since 
     * @return
     */
    public static Connection createConnection(){
   	 try {
			 Class.forName(configutation.getDriver());
			 return DriverManager.getConnection(configutation.getUrl(),configutation.getUser(), configutation.getPassword());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
    /**
     * 
     * 描述：关闭连接，多态这里，这里是关闭所有
     * @author gt
     * @created 2016年8月18日 下午11:28:03
     * @since 
     * @param resultSet
     * @param stmt
     * @param conn
     */
   public static void close(ResultSet resultSet ,Statement stmt , Connection conn){
   	if(resultSet != null){
   		try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
   	}
   	if(stmt != null){
   		try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
   	}
   	 pool.close(conn);
   }
   /**
    * 
    * 描述：关闭连接，关闭sql执行
    * @author gt
    * @created 2016年8月18日 下午11:28:34
    * @since 
    * @param stmt
    * @param conn
    */
   public static void close(Statement stmt , Connection conn){
   	if(stmt != null){
   		try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
   	}
    pool.close(conn);
   }
   /**
    * 
    * 描述：关闭数据库连接
    * @author gt
    * @created 2016年8月18日 下午11:33:46
    * @since 
    * @param conn
    */
   public static void close(Connection conn){
	   pool.close(conn);
   }
   /**
   * @Title: getConfig 
   * @Description: 获得配置文件bean实例
   * @param @return    设定文件 
   * @return Configuration    返回类型 
   * @throws
    */
   public static Configuration getConfig(){
	    return configutation;
   }
}
