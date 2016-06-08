package Annotation.demo2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 描述：列名和类属性的关系类型
 * @author gt
 * @created 2016年6月8日 下午10:39:01
 * @since
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
	 String columnName();
     String type();
     String length();
}
