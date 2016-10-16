package email;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;


import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.sun.mail.util.MailSSLSocketFactory;




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
	         prop.setProperty("mail.host", "smtp.exmail.qq.com");
	         prop.setProperty("mail.transport.protocol", "smtp");
	         prop.setProperty("mail.smtp.auth", "true");
	         prop.setProperty("mail.debug", "true");
	         //qq邮箱要以ssl加密发送
	         MailSSLSocketFactory sf = new MailSSLSocketFactory();
	         prop.put("mail.smtp.ssl.enable", "true");
	         prop.put("mail.smtp.ssl.socketFactory", sf);
	         //使用JavaMail发送邮件的5个步骤
	         //1、创建session
	         Session session = Session.getInstance(prop);
	         //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
	         session.setDebug(true);
	         //2、通过session得到transport对象
	         Transport ts = session.getTransport();
	         //3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
	         ts.connect("smtp.qq.com", "1093656744@qq.com", "icrgxgeskwigieec");//crtyfvcqbfreheda，//icrgxgeskwigieec
//	         ts.connect("smtp.qq.com", "1093656744@qq.com", "icrgxgeskwigieec");//crtyfvcqbfreheda，//icrgxgeskwigieec
	         //4、创建邮件
	         Message message = getMessageIncludeImage(session);//createSimpleMail(session);
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
	     public static MimeMessage createSimpleMail(Session session) throws Exception {
	        //创建邮件对象
	         MimeMessage message = new MimeMessage(session);
	        //指明邮件的发件人
	        message.setFrom(new InternetAddress("1093656744@qq.com"));
	        //指明邮件的收件人，Message.RecipientType.TO
	        message.setRecipient(Message.RecipientType.TO, new InternetAddress("1093656744@qq.com"));
	        //Message.RecipientType.BCC：指明邮件秘密再发送给谁,//Message.RecipientType.CC,指明需要抄送的人，单个人addRecipients
//	        message.addRecipients(Message.RecipientType.CC, new Address[]{new InternetAddress("gujt@thinkive.com"),new InternetAddress("1093656744@qq.com")});
	        //Message.RecipientType.BCC：指明邮件秘密再发送给谁
//	        message.setRecipient(Message.RecipientType.BCC, new InternetAddress("gujt@thinkive.com"));
	        //邮件的标题
	         message.setSubject("测试邮件服务");
	         //设置要指向的答复地址
//	         message.setReplyTo(new Address[]{new InternetAddress("1093656744@qq.com")});
	         //邮件的文本内容
	        message.setContent("你好啊！我是顾涛，我在测试邮件提醒服务", "text/html;charset=UTF-8");
	         //返回创建好的邮件对象
	         return message;
         }
	     public static MimeMessage getMessageIncludeImage(Session session){//,String senderAddress,String receivePerson,String subject){
	    	 //需要发送信息实体类
	    	 MimeMessage message = new MimeMessage(session);
	    	 //发送人
	    	 try {
				message.setFrom(new InternetAddress("1093656744@qq.com"));
				message.setSubject("测试带有其他内容");
				message.setRecipient(Message.RecipientType.TO, new InternetAddress("1093656744@qq.com"));
				MimeBodyPart text = new MimeBodyPart();
				text.setContent("带有图片的文件","text/html;charset=UTF-8");
				
				MimeBodyPart image = new MimeBodyPart();
			    DataHandler data = new DataHandler(new FileDataSource("F:/webjaeeWorkspace/JavaTest/config/520.jpg"));
			    image.setDataHandler(data);
			    image.setFileName(MimeUtility.encodeText(data.getName()));
//			    image.setContentID("520.jpg");
			    
			    MimeMultipart mulPart = new MimeMultipart();
			    mulPart.addBodyPart(text);
			    mulPart.addBodyPart(image);
			    mulPart.setSubType("related");
			    message.setContent(mulPart);
			    message.saveChanges();
//				message.setSender(address);
			} catch (MessagingException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
	    	 return message;
	     }
}

