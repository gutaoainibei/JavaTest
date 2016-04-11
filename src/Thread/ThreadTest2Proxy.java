package Thread;
/**
 * 
 * 描述：静态代理模式，实现同一个接口
 * @author gt
 * @created 2016年4月11日 下午3:18:03
 * @since
 */
public class ThreadTest2Proxy {
     public static void main(String[] args) {
		Marry you = new You();
		Marry weddingCompany = new WeddingCompany(you);
		weddingCompany.marry();
	}
}
interface Marry{
	public void marry();
}
class You implements Marry{
	@Override
	public void marry() {
	   System.out.println("ni marry");	
	}
	
}
class WeddingCompany implements Marry{
    private Marry you;
    public WeddingCompany(){
    	
    }
    public WeddingCompany(Marry you){
       this.you = you;	
    }
	@Override
	public void marry() {
		before();
		you.marry();
		after();
	}
	public void before(){
		System.out.println("准备工作。。。。。。。");
	}
	public void after(){
		System.out.println("闹洞房。。。。。。。。");
	}
}