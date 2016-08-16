package JDBC.detail;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
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
     public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mytest", "root", "root");
	    preparedStatement = conn.prepareStatement("insert into t_user_pwd(id,username,password,colblob,colclob) values(?,?,?,?,?)");
//	    preparedStatement.setObject(1, "1");
//	    preparedStatement.setObject(2, "gutao");
//	    preparedStatement.setObject(3, "gutao");
//	    preparedStatement.setBlob(4, new FileInputStream(new File("F:/Wallpaper/a.jpg")));
//	    preparedStatement.setClob(5, new BufferedReader(new InputStreamReader(new FileInputStream("F:/Wallpaper/a.txt"))));
//        preparedStatement.executeUpdate();
        
        preparedStatement2 = conn.prepareStatement("select * from t_user_pwd");
        resultSet = preparedStatement2.executeQuery();
        InputStream in1 = null;
        Reader in2 = null;
        OutputStream out1 = new FileOutputStream(new File("F:/Wallpaper/a1.jpg"));
        BufferedWriter out2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("F:/Wallpaper/a1.txt",true),"utf-8"));
        while (resultSet.next()) {
			Blob blob = resultSet.getBlob("colblob");
			Clob clob = resultSet.getClob("colclob");
			in1 = blob.getBinaryStream();
			in2 = clob.getCharacterStream();
			byte[] flush1 = new byte[1024];
			int len = 0 ;
			while ((len = in1.read(flush1))!= -1) {
				out1.write(flush1, 0, len);
			}
			char[] flush2 = new char[1024];
			int len2 =0 ;
			while ((len2 = in2.read(flush2))!=-1) {
				System.out.println(flush2);
				out2.write(flush2,0,flush2.length);
			}
		}
        out1.close();out2.close();
     }
}
