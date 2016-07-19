package designPattern.birdge;

/**
 * 
 * 描述：电脑
 * 
 * @author gt
 * @created 2016年7月19日 下午10:44:17
 * @since
 */
public class Computer {
	private Brand brand;

	public Computer(Brand brand) {
		super();
		this.brand = brand;
	}
    void sale(){
    	brand.sale();
    }
}
class deskTop extends Computer{

	public deskTop(Brand brand) {
		super(brand);
	}
	public void sale(){
		super.sale();
		System.out.println("销售台式机");
	}
}
class pad extends Computer{

	public pad(Brand brand) {
		super(brand);
	}
	public void sale(){
		super.sale();
		System.out.println("销售pad");

	}
}
class lapTop extends Computer{

	public lapTop(Brand brand) {
		super(brand);
	}
	public void sale(){
	    super.sale();
		System.out.println("销售笔记本");
	}
}