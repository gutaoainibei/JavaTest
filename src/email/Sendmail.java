package email;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import common.commonUtils;

/**
 * 
 * 描述：
 * @author gt
 * @created 2016年10月18日 下午3:17:37
 * @since
 */
public class Sendmail {
	    
	    /**
	     * 
	     * 描述：发送邮件
	     * @author gt
	     * @created 2016年10月18日 下午3:30:42
	     * @since 
	     * @param messageModel
	     * @throws Exception
	     */
	    public static void sendEmail(MessageModel messageModel) throws Exception {
	    	 if(messageModel == null){
	    		 return;
	    	 }
	    	 checkInput(messageModel);
	    	 Properties prop = new Properties();
	         prop.setProperty("mail.host", "smtp.qq.com");
	         prop.setProperty("mail.transport.protocol", "smtp");
	         prop.setProperty("mail.smtp.auth", "true");
	         prop.setProperty("mail.debug", "true");
	         Session session = Session.getInstance(prop);
	         Transport ts = session.getTransport();
	         ts.connect("smtp.qq.com", messageModel.getSendPerson(), messageModel.getPassword());
	         Message message = createMail(messageModel);
	         ts.sendMessage(message, message.getAllRecipients());
	         ts.close();
	    }
		  /**
		   * 
		   * 描述：创建邮件
		   * @author gt
		   * @created 2016年10月18日 下午3:23:31
		   * @since 
		   * @param modelInfo
		   * @return
		   * @throws Exception
		   */
	     public static MimeMessage createMail(MessageModel modelInfo) throws Exception {
	        MimeMessage message = new MimeMessage(modelInfo.getSession());
	        message.setFrom(new InternetAddress(modelInfo.getSendPerson()));
	        Address[] addresses = null;
	        if(modelInfo.getReceivePerson()!=null && modelInfo.getReceivePerson().length > 0){
	          addresses = getNeedAddress(modelInfo.getReceivePerson());
	          if(addresses == null){
	        	  throw new Exception("接收人地址非法");
	          }
	        }else{
				throw new Exception("邮件接收人不能为空");
			}
	        message.setRecipients(Message.RecipientType.TO, addresses);
	        message.setSubject(modelInfo.getSubject());
	        MimeMultipart mul = new MimeMultipart();
	        if(commonUtils.isNotEmpty(modelInfo.getContent())){
	        	MimeBodyPart text = new MimeBodyPart();
	        	text.setContent(modelInfo.getContent(),"text/html;charset=UTF-8");
	        	mul.addBodyPart(text);
	        }else{
	        	throw new Exception("邮件内容不得为空");
	        }
	        if(!commonUtils.isNotEmpty(modelInfo.getPathFile())){
		        MimeBodyPart file = new MimeBodyPart();
	        	DataHandler dataHandler = new DataHandler(new FileDataSource(modelInfo.getPathFile()));
	            file.setDataHandler(dataHandler);
	            file.setFileName(MimeUtility.encodeText(dataHandler.getName()));
	            mul.setSubType("mixed");
	            mul.addBodyPart(file);
	        }
	        message.setContent(mul);
	        message.saveChanges();
	        return message;
         }
	     /**
	      * 
	      * 描述：格式化地址
	      * @author gt
	      * @created 2016年10月18日 下午3:30:59
	      * @since 
	      * @param needaddresses
	      * @return
	      * @throws AddressException
	      */
		public static Address[] getNeedAddress(String[] needaddresses)
				throws AddressException {
			Address[] addresses;
			addresses = new Address[needaddresses.length];
			int count = 0;
			for (int i = 0; i < addresses.length; i++) {
				if(commonUtils.isNotEmpty(needaddresses[i])){
					addresses[i] = new InternetAddress(needaddresses[i]);
				}else{
					count++;
				}
			}
			if(count == needaddresses.length){
				return null;
			}
			return addresses;
		}
		public static void checkInput(MessageModel messageModel) throws Exception{
			if(messageModel.getSendPerson() == null || !commonUtils.isNotEmpty(messageModel.getSendPerson())){
	        	 throw new Exception("发送人不能为空！");
	         }
			if(messageModel.getPassword() == null || !commonUtils.isNotEmpty(messageModel.getPassword())){
	        	 throw new Exception("发送人校验密码为空！");
	         }
		} 
}

