package designPattern.flyweight;
/**
 * 
 * 描述：unSharedConcreteFlyWeight
 * @author gt
 * @created 2016年7月24日 下午10:48:51
 * @since
 */
public class Coordinate {
    int x,y;
   
	public Coordinate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
    
}
