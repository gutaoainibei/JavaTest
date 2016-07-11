package designPattern.Prototype;

import java.util.Date;


/**
 * 
 * 描述：测试原型模型
 * @author gt
 * @created 2016年7月12日 上午12:12:55
 * @since
 */
public class Client2 {
    public static void main(String[] args) throws CloneNotSupportedException {
    	Date date = new Date(124255654L);
		Sheep1 s1 =new Sheep1("gutao",date);
		System.out.println(s1);
		System.out.println(s1.getName());
		System.out.println(s1.getBirthday());
		
		Sheep1 s2 = (Sheep1) s1.clone();
		date.setTime(53535356L);
		System.out.println(s1.getBirthday());//这里只改变了s1的，这就是深度复制，而不是简单的引用
		System.out.println(s2);
		System.out.println(s2.getName());
		System.out.println(s2.getBirthday());
	}
}
