package log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.net.SMTPAppender;
/**
 * 描述：测试log4j
 * @author gt
 * @created 2016年10月19日 下午2:42:27
 * @since
 */
//public class TestLog1 {
//  private static Logger logger = Logger.getLogger(TestLog1.class);
//  public static void main(String[] args) {
//	  logger.error("gutao");
//}
//}
public class TestLog1 {
static Logger logger = Logger.getLogger(TestLog1.class);
SMTPAppender appender = new SMTPAppender();
public TestLog1() {
    try {
        appender.setSMTPUsername("gujt@thinkive.com");
        appender.setSMTPPassword("Gutao1111");
        appender.setTo("gutaoai@126.com");
        appender.setFrom("gujt@thinkive.com");
        // SMTP服务器 smtp.163.com
        appender.setSMTPHost("smtp.qq.com");
        appender.setLocationInfo(true);
        appender.setSubject("Test Mail From Log4J");
        appender.setLayout(new PatternLayout());
        appender.activateOptions();
        logger.addAppender(appender);
        logger.error("Hello World");
    } catch (Exception e) {
        e.printStackTrace();
        logger.info("Printing ERROR Statements", e);
    }
}
//
//log4j.appender.MAIL=org.apache.log4j.net.SMTPAppender
//# 日志的错误级别
//log4j.appender.MAIL.Threshold=ERROR
//# 缓存文件大小，日志达到512K时发送Email
//log4j.appender.MAIL.bufferSize=1
//# 发送邮件的服务器
//log4j.appender.MAIL.SMTPHost=smtp.qq.com
//# 邮件的标题
//log4j.appender.MAIL.subject=Log4J ErrorMessage
//# 用户名
//log4j.appender.MAIL.smtpUsername=gujt@thinkive.com
//# 密码
//log4j.appender.MAIL.smtpPassword=Gutao1111
//# 发件人地址
//log4j.appender.MAIL.From=gujt@thinkive.com
//# 日志邮件的接收者
//log4j.appender.MAIL.To=1093656744@qq.com
//# 日志PatternLayout
//log4j.appender.MAIL.layout=org.apache.log4j.PatternLayout
//# 日志的格式
//log4j.appender.MAIL.layout.ConversionPattern=[ErrorMessage] %d - %c -%-4r [%t] %-5p %c %x - %m%n
//#抄送给其他人  
//#log4j.appender.MAIL.Bcc=another@email.com
public static void main(String args[]) {
//    new TestLog1();
	logger.error("gutao");
}
}