package designPattern.flyweight;
/**
 * 
 * 描述：测试享元模式
 * @author gt
 * @created 2016年7月24日 下午10:40:50
 * @since
 */
public class Client {
    public static void main(String[] args) {
		ChessFlyWeight c1 = ChessFlyWeightFactory.getChess("黑色");
		ChessFlyWeight c2 = ChessFlyWeightFactory.getChess("黑色");
       System.out.println(c1);
       System.out.println(c2);
       System.out.println("添加位置");
       c1.disPlay(new Coordinate(20, 20));
       c2.disPlay(new Coordinate(10, 10));
	}
}
