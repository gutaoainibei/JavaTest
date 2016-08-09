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
		//建立连接(连接对象内部其实包含了Socket对象，是一个远程的连接，比较耗时，这是Connection对象管理的一个要点)
		//真正开发中，为了提高效率，都会使用连接池来管理连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mytest", "root", "root");
	    long endTime = System.currentTimeMillis();
	    System.out.println("连接消耗的时间："+(endTime-startTime));
		System.out.println(conn);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
