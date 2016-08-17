package MYORM;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

/**
 * 
 * 描述：数据库连接工具
 * @author gt
 * @created 2016年8月17日 下午8:32:52
 * @since
 */
public class JdbcUtils {
     private static Connection conn = null;
     private static PreparedStatement preStmt = null;
     private static Properties properties = null;
     static{
    	 properties = new Properties();
    	 try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    	 try {
			Class.forName(properties.getProperty("driver"));
			conn = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
	        System.out.println(conn);
    	 } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	 
     }
     public static Connection getConnection(){
    	 return conn;
     }
     public static ResultSet getResult(String sql){
    	 return null;
     }
     public static void main(String[] args) {
		JdbcUtils.getConnection();
	}
}
