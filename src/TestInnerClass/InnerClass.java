package TestInnerClass;

import TestInnerClass.Face.ear;
import TestInnerClass.Face.nose;

public class InnerClass {
  public static void main(String[] args) {
	  Face f = new Face();
	  //内部类就像外部类的一个属性一样，必须有对象来调用
	  nose n = f.new nose();
	  //静态内部类可以直接写，因为这是已经写在方法区中的，可以直接调用
	  //也可以下面那样
	  ear e = new ear();
	  ear e1 = new Face.ear();
	  e1.listen();
	  n.smell();
	  e.listen();
  }
}
class Face{
	String eye="单眼皮";
	class nose{
		String type="高鼻梁";
		String eye="两个鼻孔";
		public void smell(){
			System.out.println("闻到了一股味道");
			//内部类调用外部类相同的属性，就是下面这样调用的
			//如果没有一样属性，可以直接调用
			System.out.println(Face.this.eye);
		}
		
	}
	static class ear{
		String type="招风耳";
		public void listen(){
			System.out.println("听到一首曲子");
		}
	}
}