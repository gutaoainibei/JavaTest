package TestFreechaet;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.print.attribute.standard.MediaName;

import com.mysql.jdbc.Connection;

public class DB {
   private static String drivername="com.mysql.jdbc.Driver";
   private static String url="jdbc:mysql://127.0.0.1:3306/test";
   private static String username="root";
   private static String pass="root";
   public static Connection getConn() throws Exception{
	   Class.forName(drivername);
		  Connection conn = (Connection) DriverManager.getConnection(url, username, pass);
		  return conn;
   }
}
