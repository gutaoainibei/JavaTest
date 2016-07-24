package designPattern.flyweight;
/**
 * 
 * 描述：享元模式的抽象接口
 * @author gt
 * @created 2016年7月24日 下午10:46:11
 * @since
 */
public interface ChessFlyWeight {
   void setColor(String c);
   void disPlay(Coordinate coordinate);
   String getColor();
}
