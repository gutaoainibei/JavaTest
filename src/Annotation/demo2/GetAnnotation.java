package Annotation.demo2;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GetAnnotation {
   private Class clazz; 
   private String TableName;
   private List<Map<String,String>> columnsList;
   public void getTableClass(Class c) throws ClassNotFoundException{
	   clazz = Class.forName("Annotation.demo2.Shoping");
	   Table table = (Table)clazz.getAnnotation(Table.class);
	   TableName = table.value();
	   Field[] fields = clazz.getDeclaredFields();
	   columnsList = new ArrayList<Map<String,String>>();
	   for (Field field : fields) {
		    Map map = new HashMap<String, String>();
			Column column = (Column)field.getAnnotation(Column.class);
			map.put("columnName", column.columnName());
			map.put("type", column.type());
			map.put("length", column.length());
			columnsList.add(map);
	   }
   }
   public static void main(String[] args) throws Exception {
             GetAnnotation getAnnotation = new GetAnnotation();
             getAnnotation.getTableClass(Shoping.class);
             System.out.println(getAnnotation.TableName);
             for (Map map : getAnnotation.columnsList) {
				System.out.println(map.get("columnName")+","+map.get("type")+","+map.get("length"));
			}
   }
}
