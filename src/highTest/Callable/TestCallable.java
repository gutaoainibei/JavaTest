package highTest.Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
* @ClassName: TestCallable 
* @Description: TODO(测试callable) 
* @author gutao 
* @date 2016年9月17日 上午9:09:19 
* String是你要返回的类型
 */
public class TestCallable implements Callable<String>{

	@Override
	public String call() throws Exception {
		for (int i = 0; i < 10 ; i++ ) {
			System.out.println("gt"+i);
		}
		return "结束";
	}
    public static void main(String[] args) throws InterruptedException, ExecutionException {
    	TestCallable highCall = new TestCallable();
		FutureTask<String> task = new FutureTask<String>(highCall);
		new Thread(task).start();
		System.out.println(task.get());
 	}
}
