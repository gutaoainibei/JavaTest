package designPattern.Proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 
 * 描述：处理器
 * @author gt
 * @created 2016年7月18日 上午12:05:00
 * @since
 */
public class starHandler implements InvocationHandler{
    private realStar realStar;
    
	public starHandler(realStar realStar) {
		super();
		this.realStar = realStar;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object object = null;
		//在代理里面做业务逻辑处理
		System.out.println("#############");
		if(method.getName().equals("sing")){
		   method.invoke(realStar, args);
		}
		return object;
	}

}
