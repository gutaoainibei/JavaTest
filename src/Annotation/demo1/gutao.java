package Annotation.demo1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 
 * 描述：自定义注解，
 *          target是应用范围目标；
 *          target：常用的 TYPE(类型：基本类型，Class，interface，String，enum)，FIELD，METHOD，PACKAGE
 *          retention是生命周期，可以看作是作用域；
 *          retention： SOURCE，CLASS，RUNTIME；三种情况，从左往右作用范围以此增大
 * @author gt
 * @created 2016年6月7日 下午5:01:55
 * @since
 */
@Target(value={ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface gutao {
     String name();
     int age();
}
