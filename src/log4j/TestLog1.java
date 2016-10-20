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

public static void main(String args[]) {
//    new TestLog1();
	logger.error("gutao");
}
}