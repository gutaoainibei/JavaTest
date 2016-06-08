package Annotation.demo2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 描述：ORM,Object Relation Mapping
 *     表对应的关系类
 * @author gt
 * @created 2016年6月8日 下午10:35:27
 * @since
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
     String value();
}
