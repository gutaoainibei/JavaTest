package MYORM;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client1 {
	 private static Connection  connection = null;
     public static void main(String[] args){
    	 connection = JdbcUtils.getConnection();
    	 Statement stmtStatement = null;
    	 ResultSet resultSet = null;
    	 List<Object[]> list = new ArrayList<Object[]>();
    	 List<Map<String, Object>> maps = new ArrayList<Map<String,Object>>();
    	 List<Emp> lists = new ArrayList<Emp>();
    	 try {
    		stmtStatement = connection.createStatement();
			resultSet = stmtStatement.executeQuery("select * from test");
			Object[] objs = null;
			while (resultSet.next()) {
				objs = new Object[2];
				Map<String, Object> map = new HashMap<String, Object>();
				Emp emp = new Emp();
				map.put("id", resultSet.getString(1));
				map.put("name", resultSet.getString(2));
				objs[0] = resultSet.getString(1);
				objs[1] = resultSet.getString(2);
				emp.setId(resultSet.getString(1));
				emp.setName(resultSet.getString(2));
				list.add(objs);
				maps.add(map);
				lists.add(emp);
			}
			for (Object[] object : list){
				System.out.println(object[0]+","+object[1]);
			}
			System.out.println("---------------------------------");
			for (Map map : maps) {
				System.out.println(map.get("id")+","+map.get("name"));
			}
			System.out.println("---------------------------------");
			for (Emp emp : lists) {
				System.out.println(emp.getId()+","+emp.getName());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
