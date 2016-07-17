package designPattern.Proxy.dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * 
 * 描述：测试
 * @author gt
 * @created 2016年7月18日 上午12:04:48
 * @since
 */
public class Client {
    public static void main(String[] args) {
		realStar realStar = new realStar();
		starHandler handler = new starHandler(realStar);
		Star proxyStar = (Star)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Star.class}, handler);
	    proxyStar.sing();
	    proxyStar.bookTicket();
    }
}
