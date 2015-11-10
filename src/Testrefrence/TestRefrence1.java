package Testrefrence;
/**
 * 
* @ClassName: TestRefrence1 
* @Description: TODO(测试对象引用) 
* @author gutao 
* @date 2015年11月10日 下午1:11:26 
*
 */
public class TestRefrence1 {
    public void Test1(Test11 t){
    	t.i = 2;
    	t.name = "gt";
    }
    public void Test2(int i){
    	i = 4;
    }
    public static void main(String[] args) {
		Test11 tt = new Test11();
		TestRefrence1 tr = new TestRefrence1();
		System.out.println("---test.i1:"+tt.i);
		System.out.println("---test.name1:"+tt.name);
		tr.Test1(tt);
		tr.Test2(tt.i);
		System.out.println("---test.i2:"+tt.i);
		System.out.println("---test.name2:"+tt.name);
	}
}
class Test11{
	public int i = 0;
	public String name = "gutao";
}