package designPattern.flyweight;

public class ConcreteChess implements ChessFlyWeight{
    String color;
	public ConcreteChess(String color) {
		super();
		this.color = color;
	}

	public void setColor(String c) {
		this.color = c;
	}

	public void disPlay(Coordinate coordinate) {
		System.out.println("棋子颜色:"+color);
		System.out.println("棋子位置："+coordinate.getX()+","+coordinate.getY());
	}

	public String getColor() {
		return color;
	}


  
}
