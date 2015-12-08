package TestCallBack;

public class TestCallMain {
   public static void DoPaint(PaintFrame f){
	   System.out.println("启动线程");
	   System.out.println("开始画画");
	   f.Paint();//回掉，用的就是多态
	   System.out.println("画画结束");
   }
   public static void main(String[] args) {
	 DoPaint(new circle());
   }
}
class circle extends PaintFrame{

	@Override
	public void Paint() {
		System.out.println("画圆");
		
	}
	
}
class square extends PaintFrame{

	@Override
	public void Paint() {
		System.out.println("画方形");
	}
	
}
