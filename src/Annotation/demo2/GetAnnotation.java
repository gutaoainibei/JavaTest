package Annotation.demo2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;


public class GetAnnotation {
   public static void main(String[] args) throws Exception {
	Class clazz = Class.forName("Annotation.demo2.Shoping");
	Table table = (Table)clazz.getAnnotation(Table.class);
    Field[] fields = clazz.getDeclaredFields();
    for (Field field : fields) {
		System.out.println(field.getName());
		Column column = (Column)field.getAnnotation(Column.class);
		System.out.println(column.columnName()+"-->"+column.type()+"-->"+column.length());
	}
	
}
}
