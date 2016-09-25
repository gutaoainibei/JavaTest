package MYORM.orm.com.gt.sorm.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

import MYORM.orm.com.gt.sorm.bean.Configuration;
import designPattern.Proxy.dynamicProxy.starHandler;
public class DBManager {
    private static Configuration configutation;
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
		    configutation.setUsingDB(properties.getProperty("usingDB"));
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
   	if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
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
   	if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
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
   	if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
   }
   public static Configuration getConfig(){
	    return configutation;
   }
   public static void main(String[] args) {
	Connection connection = DBManager.getConnection();
	System.out.println("获取连接："+connection);
//	System.out.println(configutation);
	System.out.println(configutation.getUsingDB());
}
}
