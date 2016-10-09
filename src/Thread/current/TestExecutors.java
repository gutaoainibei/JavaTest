package Thread.current;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 
* @ClassName: TestExecutors 
* @Description: 试用executors建立连接词
* @author gutao 
* @date 2016年10月9日 下午3:20:33 
*
 */
public class TestExecutors {
    public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
        	 executorService.execute(new myRunnable("gt"+i));
		}
        executorService.shutdown();
    }
}
