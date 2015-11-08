package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestOracleJdbc {
    public static void main(String[] args) {
    	Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","system","Gutao1111");
		} catch (ClassNotFoundException e) {
			System.out.println("没有找到驱动类！");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("数据库连接失败！");
			e.printStackTrace();
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
