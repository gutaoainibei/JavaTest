package email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



/**
 * 
 * 描述：发邮件测试
 * @author gt
 * @created 2016年10月14日 下午3:17:11
 * @since
 */
public class Sendmail {
	      /**
	      * @param args
	      * @throws Exception 
	      */
	    public static void main(String[] args) throws Exception {
	         
	         Properties prop = new Properties();
	         prop.setProperty("mail.host", "smtp.qq.com");
	         prop.setProperty("mail.transport.protocol", "smtp");
	         prop.setProperty("mail.smtp.auth", "true");
	         prop.setProperty("mail.debug", "true");
//	         MailSSLSocketFactory sf = new MailSSLSocketFactory();
//	         prop.put("mail.smtp.ssl.enable", "true");
//	         prop.put("mail.smtp.ssl.socketFactory", sf);
	         //使用JavaMail发送邮件的5个步骤
	         //1、创建session
	         Session session = Session.getInstance(prop);
	         //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
	         session.setDebug(true);
	         //2、通过session得到transport对象
	         Transport ts = session.getTransport();
	         //3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
	         ts.connect("smtp.qq.com", "gujt@thinkive.com", "Gutao1111");//crtyfvcqbfreheda，//icrgxgeskwigieec
	         //4、创建邮件
	         Message message = createSimpleMail(session);
	         //5、发送邮件
	         ts.sendMessage(message, message.getAllRecipients());
	         ts.close();
	     }
	    
	  /**
	   * 
	   * 描述：创建一封只包含文本的邮件
	   * @author gt
	   * @created 2016年10月14日 下午3:18:39
	   * @since 
	   * @param session
	   * @return
	   */
	     public static MimeMessage createSimpleMail(Session session)
	            throws Exception {
	        //创建邮件对象
	         MimeMessage message = new MimeMessage(session);
	        //指明邮件的发件人
	        message.setFrom(new InternetAddress("gujt@thinkive.com"));
	         //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
	        message.setRecipient(Message.RecipientType.TO, new InternetAddress("zhangjy@thinkive.com"));
	        //邮件的标题
	         message.setSubject("测试邮件服务");
	         //邮件的文本内容
	        message.setContent("菊艳你好啊！我是顾涛，我在测试邮件提醒服务", "text/html;charset=UTF-8");
	         //返回创建好的邮件对象
	         return message;
     }

}
class PopAuthenticator extends Authenticator {
    String userName = null;
       String password = null;
       public PopAuthenticator() {
       }
       public PopAuthenticator(String username, String password) {
           this.userName = username;
           this.password = password;
       }
       protected PasswordAuthentication getPasswordAuthentication() {
           return new PasswordAuthentication(userName, password);
       }
}
