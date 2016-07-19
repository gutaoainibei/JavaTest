package designPattern.birdge;
/**
 * 
 * 描述：品牌接口
 * @author gt
 * @created 2016年7月19日 下午10:32:40
 * @since
 */
public interface Brand {
    void sale();
}
class Lenovo implements Brand{

	@Override
	public void sale() {
		System.out.println("销售联想电脑");
	}
	
}
class Shenzhou implements Brand{

	@Override
	public void sale() {
		System.out.println("销售神州电脑");
	}
	
}
class Dell implements Brand{

	@Override
	public void sale() {
		System.out.println("销售戴尔电脑");
	}
	
}