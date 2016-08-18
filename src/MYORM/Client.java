package MYORM;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Client {
   public static void main(String[] args) {
	Connection conn = JdbcUtils.getConnection();
	try {
		Statement stmt = conn.createStatement();
		ResultSet resultSet = stmt.executeQuery("select *from test");
		while (resultSet.next()) {
			System.out.println(resultSet.getString(1)+","+resultSet.getString(2));
		}
		JdbcUtils.close(resultSet, stmt, conn);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
