package JDBC.detail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * 描述：测试jdbc，初识jdbc
 * @author gt
 * @created 2016年8月4日 下午11:46:43
 * @since
 */
public class Client {
   public static void main(String[] args) {
	try {
		//初始化驱动类，加载到内存中
		Class.forName("com.mysql.jdbc.Driver");
		long startTime = System.currentTimeMillis();
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mytest", "root", "root");
	    System.out.println(conn);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
