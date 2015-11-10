package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestUpdateDate {
	  static Connection conn = null;
	  static PreparedStatement preparedStatement = null;
      public static void main(String[] args) {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root","root");
//		    preparedStatement = conn.prepareStatement("insert into user values(?,?,?)");
//          用于批量更新，这种方法可以防止sql注入
		    preparedStatement = conn.prepareStatement("update `user` set `name`=?,age=? WHERE id=?");
		    conn.setAutoCommit(false);
		    for(int i=0 ; i<3 ; i++){
		    	preparedStatement.setInt(2, i+10);
		    	preparedStatement.setString(1, "gutao"+i);
		    	preparedStatement.setInt(3, i+10);
		    	preparedStatement.addBatch();
		    }
		    //批量执行sql语句
	        preparedStatement.executeBatch();
	        //提交
		    conn.commit();
//		    //开启自动提交
    	   conn.setAutoCommit(true);
    	   
    	} catch (ClassNotFoundException e) {
			System.out.println("找不到驱动类！");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("数据库连接失败！");
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null){
					preparedStatement.close();
					preparedStatement = null;
				}
				if(conn != null){
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
