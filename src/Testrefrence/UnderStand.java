package Testrefrence;
/**
 * 
 * 描述：用来检测关于对象引用的问题
 * @author gt
 * @created 2016年2月19日 下午11:35:30
 * @since
 */
public class UnderStand {
   public static void main(String[] args) {
	String[] s1 = {"1","2","3"};
	String[] s2 = s1;
	s2[2]="gutao";
	for (String string : s2) {
		System.out.println(string);
	}
	for (String string : s1) {
		System.out.println(string);
	}
}
}
