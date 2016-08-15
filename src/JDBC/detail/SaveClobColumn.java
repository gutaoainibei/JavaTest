package JDBC.detail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaveClobColumn {
	static Connection conn = null;
	static PreparedStatement preparedStatement = null;
	static PreparedStatement preparedStatement2 = null;
	static ResultSet resultSet = null;
     public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mytest", "root", "root");
	    preparedStatement = conn.prepareStatement("insert into t_user_pwd(id,username,password,colblob,colclob) values(?,?,?,?,?)");
	    preparedStatement.setObject(1, "1");
	    preparedStatement.setObject(2, "gutao");
	    preparedStatement.setObject(3, "gutao");
	    preparedStatement.setBlob(4, new FileInputStream(new File("F:/Wallpaper/a.jpg")));
	    preparedStatement.setClob(5, new BufferedReader(new InputStreamReader(new FileInputStream("F:/Wallpaper/a.txt"))));
        preparedStatement.executeUpdate();
        
        preparedStatement2 = conn.prepareStatement("select * from t_user_pwd")
     }
}
