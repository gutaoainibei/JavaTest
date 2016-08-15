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
 * 描述：事务测试
 * @author gt
 * @created 2016年8月9日 下午11:08:17
 * @since
 */
public class EfficientByUpdateAndDelInsert {
	static Connection conn = null;
	static PreparedStatement preparedStatement = null;
	static PreparedStatement preparedStatement2 = null;
	static ResultSet resultSet = null;
    public static void main(String[] args) {
    	
         try {
			Class.forName("com.mysql.jdbc.Driver");
		    conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mytest", "root", "root");
		    conn.setAutoCommit(false);
		    long start = System.currentTimeMillis();
		    Statement statement =conn.createStatement();
		  //  resultSet = statement.executeQuery("select * from t_user_pwd");
		   // if(!resultSet.next()){//查询插入用了334毫秒,更新用了943毫秒
		 //   preparedStatement = conn.prepareStatement("insert into t_user_pwd values(?,?,?)");
		    preparedStatement = conn.prepareStatement("update t_user_pwd set username='gt' where id = ?");
        	for (int i = 0; i < 1000; i++) {
        		preparedStatement.setObject(1, i);
                preparedStatement.executeUpdate();
			}
        //	}
            conn.commit();
            long end = System.currentTimeMillis();
            System.out.println("用时："+(end-start));//10000条，用时：1822
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
