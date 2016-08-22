package MYORM;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

import designPattern.Singletons.staticSimpledemo;

/**
 * 
 * 描述：数据库连接工具
 * @author gt
 * @created 2016年8月17日 下午8:32:52
 * @since
 */
public class JdbcUtils {
     private static Connection conn = null;
     private static Properties properties = null;
     
     static{
    	 properties = new Properties();
    	 try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
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
			 Class.forName(properties.getProperty("driver"));
			 conn = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	 return conn;
     }
     /**
      * 
      * 描述：获取连接
      * @author gt
      * @created 2016年8月18日 下午11:19:55
      * @since 
      * @return
      */
     public static Connection getOrclConn(){
    	 try {
			 Class.forName(properties.getProperty("orcldriver"));
			 conn = DriverManager.getConnection(properties.getProperty("orclurl"), properties.getProperty("orclusername"), properties.getProperty("orclpassword"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	 return conn;
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
}
