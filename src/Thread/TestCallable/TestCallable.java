package Thread.TestCallable;

import java.util.concurrent.Callable;

/**
 * 
 * 描述：相对于Runnable接口返回结果并且可能抛出异常的任务。
 *      实现者定义了一个不带任何参数的叫做 call 的方法。 
 * @author gt
 * @created 2016年4月11日 下午5:53:42
 * @since
 */
public class TestCallable implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		
		return 100;
	}
    public static void main(String[] args) {
		
	}
}
