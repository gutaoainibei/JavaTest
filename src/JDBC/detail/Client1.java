package JDBC.detail;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import designPattern.Proxy.dynamicProxy.starHandler;


/**
 * 
 * 描述：测试预处理
 * @author gt
 * @created 2016年8月9日 下午11:08:17
 * @since
 */
public class Client1 {
	static Connection conn = null;
	static PreparedStatement preparedStatement = null;
	static ResultSet resultSet = null;
    public static void main(String[] args) {
    	
         try {
			Class.forName("com.mysql.jdbc.Driver");
		    conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mytest", "root", "root");
		    preparedStatement = conn.prepareStatement("insert into t_user_pwd values(?,?,?)");
            preparedStatement.setObject(1, 1114);
            preparedStatement.setObject(2, "gutao");
            preparedStatement.setObject(3, "gutao");
            preparedStatement.executeUpdate();
            PreparedStatement sele = conn.prepareStatement("select * from t_user_pwd");
            resultSet = sele.executeQuery();
            while (resultSet.next()) {
				System.out.println(resultSet.getString(1)+","+resultSet.getString(2)+","+resultSet.getString(3));
			}
         } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
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
