package JDBC.detail;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import designPattern.Proxy.dynamicProxy.starHandler;


/**
 * 
 * 描述：batch
 * @author gt
 * @created 2016年8月9日 下午11:08:17
 * @since
 */
public class Client2 {
	static Connection conn = null;
	static PreparedStatement preparedStatement = null;
	static ResultSet resultSet = null;
    public static void main(String[] args) {
    	
         try {
			Class.forName("com.mysql.jdbc.Driver");
		    conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mytest", "root", "root");
		    conn.setAutoCommit(false);
		    long start = System.currentTimeMillis();
		    preparedStatement = conn.prepareStatement("insert into t_user_pwd values(?,?,?)");
            for (int i = 0; i < 10000; i++) {
            	preparedStatement.setObject(1, i);
                preparedStatement.setObject(2, "gutao"+i);
                preparedStatement.setObject(3, "gutao"+i);
                preparedStatement.addBatch();
			}
            preparedStatement.executeBatch();
            conn.commit();
            long end = System.currentTimeMillis();
            System.out.println("用时："+(end-start));
         } catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			//关闭连接由里向外层层关闭，不要放在同一个try中因为如果放在同一个try中出现一个异常下面的就都不会关闭了
			try {
				if(resultSet != null){
					resultSet.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
				try {
					if(resultSet != null){
						resultSet.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				try {
					if(preparedStatement != null){
						preparedStatement.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				try {
					if(conn != null){
					   conn.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
		}
    }
}
