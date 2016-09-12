package test;

/**
 * 
* @ClassName: Lamda 
* @Description: TODO(测试lamda表达式) 
* @author gutao 
* @date 2016年9月9日 上午12:41:08 
*
 */
public class Lamda {
   public static void main(String[] args) {
	 new Thread(()->{
		 for(int i = 0;i < 10 ; i++){
			 System.out.println("gutao"+i);
		 }
	 }).start();
	 new Thread(()->{
		 for(int i = 0;i < 10 ; i++){
			 System.out.println("nibei"+i);
		 }
	 }).start();
	 System.out.println("wo ai ni");
	 for (int i = 0; i < 10; i++) {
		System.out.println("gt"+i);
	}
}
}
