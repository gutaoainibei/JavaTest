package JDBC.detail;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * 
 * 描述：测试预处理
 * @author gt
 * @created 2016年8月9日 下午11:08:17
 * @since
 */
public class Client1 {
    public static void main(String[] args) {
         try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mytest", "root", "root");
		    PreparedStatement preparedStatement = conn.prepareStatement("insert into t_user_pwd values(?,?,?)");
            preparedStatement.setObject(1, 1112);
            preparedStatement.setObject(2, "gutao");
            preparedStatement.setObject(3, "gutao");
            preparedStatement.execute();
         } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
