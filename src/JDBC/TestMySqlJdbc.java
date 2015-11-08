package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class TestMySqlJdbc {
	static Connection conn = null;
    public static void main(String[] args) {
	   try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "root");
	} catch (ClassNotFoundException e) {
		System.out.println("没有找到驱动类！");
		e.printStackTrace();
	} catch (SQLException e) {
		System.out.println("数据库连接失败！");
		e.printStackTrace();
		System.exit(-1);
	}finally {
		 try {
				if(conn!=null){
					System.out.println(conn);
					conn.close();
					conn = null;
			    }
			 } catch (SQLException e) {
				e.printStackTrace();
			 }
    }
	}
}
