package regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * 描述：测试正则表达式
 * @author gt
 * @created 2016年8月1日 下午11:06:25
 * @since
 */
public class Client {
      public static void main(String[] args) {
		String str = "sdasd23**sdsd1232**323sAdF";
		Pattern pattern = Pattern.compile("\\w+", Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(str);
	    //Attempts to match the entire region against the pattern. 
	    //试图将整个区域与正则匹配
//	    boolean flag1 = matcher.matches();
//	    System.out.println(flag1);
	    //这里会一直往下面去找
//	    System.out.println(matcher.find());
//	    System.out.println(matcher.find());
//	    System.out.println(matcher.find());
//	    System.out.println(matcher.find());
	    //Attempts to find the next subsequence of the input sequence that matches the pattern
	    // Resets this matcher and then attempts to find 
	    //the next subsequence of the input sequence 
	    //that matches the pattern, starting at the specified index
        while (matcher.find()) {
        	//这里marcher的group()方法group(0)是一样的效果
        	//从1开始表示第一个匹配字符串，依次往下
			System.out.println(matcher.group());
			System.out.println(matcher.group(0));
		}
      }
}
