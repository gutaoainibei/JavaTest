package MYORM;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Client {
   public static void main(String[] args) {
	Connection conn = JdbcUtils.getConnection();
	Connection connection = JdbcUtils.getOrclConn();
	Statement stmt = null;
	Statement statement = null;
	ResultSet resultSet = null;
	ResultSet resultSet2 =null;
	try {
		stmt = conn.createStatement();
		statement = connection.createStatement();
		resultSet = stmt.executeQuery("select *from test");
		resultSet2 = statement.executeQuery("select * from emp");
		while (resultSet.next()) {
			System.out.println(resultSet.getString(1)+","+resultSet.getString(2));
		}
		while (resultSet2.next()) {
			System.out.println(resultSet2.getString(1)+","+resultSet2.getString(2));
		}
		JdbcUtils.close(resultSet, stmt, conn);
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		JdbcUtils.close(resultSet, stmt, conn);
		JdbcUtils.close(resultSet2, statement, connection);
	}
	
}
}
