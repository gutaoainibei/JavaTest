package designPattern.birdge;
/**
 * 
 * 描述：桥模式测试
 * @author gt
 * @created 2016年7月19日 下午10:31:21
 * @since
 */
public class Client {
   public static void main(String[] args) {
	  Computer computer = new lapTop(new Dell());
	  computer.sale();
}
}
