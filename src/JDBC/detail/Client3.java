package JDBC.detail;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import designPattern.Proxy.dynamicProxy.starHandler;


/**
 * 
 * 描述：测试预处理
 * @author gt
 * @created 2016年8月9日 下午11:08:17
 * @since
 */
public class Client3 {
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet resultSet = null;
    public static void main(String[] args) {
    	
         try {
			Class.forName("com.mysql.jdbc.Driver");
		    conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mytest", "root", "root");
		    conn.setAutoCommit(false);
		    long start = System.currentTimeMillis();
		    stmt = conn.createStatement();
		    for (int i = 0; i < 10000; i++) {
			    stmt.addBatch("insert into t_user_pwd values('"+i+"','"+"nb"+i+"','"+"nb"+i+"')");
		    }
		    stmt.executeBatch();
             conn.commit();
             long end = System.currentTimeMillis();
             System.out.println("用时："+(end-start));//1000条用时：269,10000用时：2333
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
					if(stmt != null){
						stmt.close();
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
