package designPattern.Prototype;

public class TestPrototypeeffcient {
   public static void main(String[] args) throws CloneNotSupportedException {
	  long s1 = System.currentTimeMillis();
	  for (int i = 0; i < 1000; i++) {
		lampTop l1 = new lampTop();
	}
	  long e1 = System.currentTimeMillis();
	  System.out.println("正常new耗时:"+(e1-s1));
	  long s2 = System.currentTimeMillis();
	  lampTop lampTop = new lampTop();
	  for (int i = 0; i < 1000; i++) {
		   lampTop ll = (lampTop) lampTop.clone();
	  }
	  long e2 = System.currentTimeMillis();
	  System.out.println("克隆用时:"+(e2-s2));
   }
}
class lampTop implements Cloneable{
	public lampTop(){
		try {
			new Thread().sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}