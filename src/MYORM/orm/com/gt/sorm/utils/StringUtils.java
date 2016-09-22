package MYORM.orm.com.gt.sorm.utils;

public class StringUtils {
    public static String upFirstCharOfString(String str){
    	return str.substring(0, 1).toUpperCase()+str.substring(1);
    }
    public static void main(String[] args) {
		System.out.println(StringUtils.upFirstCharOfString("gutao"));
	}
}
