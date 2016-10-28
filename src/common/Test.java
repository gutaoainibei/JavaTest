package common;

import email.MessageModel;
import email.Sendmail;

/**
 * 
 * 描述：工具类测试
 * @author gt
 * @created 2016年10月26日 上午10:47:06
 * @since
 */
public class Test {
    public static void main(String[] args) {
		MessageModel messageModel = new MessageModel();
      messageModel.setSubject("项目出错邮件提醒");//主题
      messageModel.setSendPerson("gujt@thinkive.com");//发送人
      messageModel.setPassword("Gutao1111");
      messageModel.setContent("项目出现异常时，会发出邮件提醒并把日志作为附件发出");//内容
      messageModel.setReceivePerson(new String[]{"liulin@thinkive.com"});//接收人
      messageModel.setCopyreceivePerson(new String[]{"liuwf@thinkive.com"});//抄送人
      messageModel.setPathFile("D:/develop/workspace1/thinkive-sj1-YTG-bus/log/busjava.log");//附件地址
      try {
			Sendmail.sendEmail(messageModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
