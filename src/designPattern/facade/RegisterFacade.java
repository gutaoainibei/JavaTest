package designPattern.facade;
/**
 * 
 * 描述：测试外观模式
 * @author gt
 * @created 2016年7月23日 下午11:16:35
 * @since
 */
public class RegisterFacade {
   public void openAccount(){
	   工商局 industrial = new 工商局();
	   industrial.register();
	   税务局 taxOffice = new 税务局();
	   taxOffice.padTax();
	   质检局 checkQuality = new 质检局(); 
	   checkQuality.check();
	   银行 bank = new 银行();
	   bank.openAccount();
   }
}
