package email;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
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
//	         ts.connect("smtp.qq.com", "1093656744@qq.com", "icrgxgeskwigieec");//crtyfvcqbfreheda，//icrgxgeskwigieec
	         //4、创建邮件
	         MessageModel messageModel = new MessageModel();
	         messageModel.setSession(session);
	         messageModel.setSubject("测试一下封装类");
	         messageModel.setSendPerson("gujt@thinkive.com");
	         messageModel.setContent("大家好这是我的java mail封装邮件测试类");
	         messageModel.setReceivePerson(new String[]{"1093656744@qq.com","gujt@thinkive.com"});
	         messageModel.setCopyreceivePerson(new String[]{"gujt@thinkive.com","1093656744@qq.com"});
	         Message message = createSimpleMail(messageModel);//getMessageIncludeImage(session);
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
	     public static MimeMessage createSimpleMail(MessageModel modelInfo) throws Exception {
	        //创建邮件对象
	         MimeMessage message = new MimeMessage(modelInfo.getSession());
	        //指明邮件的发件人
	        message.setFrom(new InternetAddress(modelInfo.getSendPerson()));
	        //指明邮件的收件人，Message.RecipientType.TO
	        Address[] addresses = null;
	        if(modelInfo.getReceivePerson()!=null && modelInfo.getReceivePerson().length > 0){
	          addresses = new Address[modelInfo.getReceivePerson().length];
	          for (int i = 0; i < addresses.length ; i++) {
	        	  addresses[i] = new InternetAddress(modelInfo.getReceivePerson()[i]);
			  }
	        }else{
				throw new Exception("接受人地址不能为空");
			}
	        Address[] copyaddresses = null;
	        if(modelInfo.getCopyreceivePerson()!=null && modelInfo.getCopyreceivePerson().length > 0){
	            copyaddresses = new Address[modelInfo.getCopyreceivePerson().length];
		        for (int i = 0; i < copyaddresses.length ; i++) {
		        	copyaddresses[i] = new InternetAddress(modelInfo.getCopyreceivePerson()[i]);
				}
	        }
	        Address[] bccaddresses = null;
	        if(modelInfo.getBccreceivePerson()!=null && modelInfo.getBccreceivePerson().length > 0){
	        	bccaddresses = new Address[modelInfo.getBccreceivePerson().length];
		        for (int i = 0; i < copyaddresses.length ; i++) {
		        	bccaddresses[i] = new InternetAddress(modelInfo.getBccreceivePerson()[i]);
				}
	        }
	        
	        //Message.RecipientType.TO,指明需要发送的人
	        message.setRecipients(Message.RecipientType.TO, addresses);
	        //Message.RecipientType.CC：指明需要抄送的人
	        message.setRecipients(Message.RecipientType.CC, copyaddresses);
	        //Message.RecipientType.BCC：指明邮件秘密再发送给谁
	        message.setRecipients(Message.RecipientType.BCC, bccaddresses);
	        //邮件的标题
	        message.setSubject(modelInfo.getSubject());//
	         //设置要指向的答复地址
//	         message.setReplyTo(new Address[]{new InternetAddress("1093656744@qq.com")});
	         //邮件的文本内容
	        message.setContent(modelInfo.getContent(), "text/html;charset=UTF-8");
	         //返回创建好的邮件对象
	         return message;
         }
	     public static MimeMessage getMessageIncludeImage(Session session,String subject,String senderAddress,String receivePerson,String pathFile){
	    	 //需要发送信息实体类
	    	 MimeMessage message = new MimeMessage(session);
	    	 //发送人
	    	 try {
				message.setFrom(new InternetAddress(senderAddress));
				message.setSubject(subject);
				message.setRecipient(Message.RecipientType.TO, new InternetAddress(receivePerson));
				MimeBodyPart text = new MimeBodyPart();
				text.setContent("带有图片的文件","text/html;charset=UTF-8");
				MimeBodyPart image = new MimeBodyPart();
			    DataHandler data = new DataHandler(new FileDataSource(pathFile));//"F:/webjaeeWorkspace/JavaTest/config/520.jpg"
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

