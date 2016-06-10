package Reflection;

import Annotation.demo2.GetAnnotation;

public class Test1 {
   public static void main(String[] args) throws ClassNotFoundException {
	GetAnnotation getAnnotation = new GetAnnotation();
	System.out.println(getAnnotation.getClass().hashCode());
	System.out.println(GetAnnotation.class.hashCode());
	System.out.println(Class.forName("Annotation.demo2.GetAnnotation").hashCode());
}
}
