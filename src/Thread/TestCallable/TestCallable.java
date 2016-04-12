package Thread.TestCallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import Thread.ThreadTest1;

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
    public static void main(String[] args) throws InterruptedException, ExecutionException {
    	 	
	}
    /**
     * 
     * 描述：Callable中应用Runnable的继承类
     * @author gt
     * @created 2016年4月11日 下午9:57:13
     * @since 
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public static void TestCallableApplyRunnable() throws InterruptedException, ExecutionException{
    	ThreadTest1 t1 = new ThreadTest1();
    	ExecutorService e1 = Executors.newFixedThreadPool(1);
    	Future<Integer> f1 = (Future<Integer>) e1.submit(t1);
    	System.out.println(f1.get());
        e1.shutdown();   
    }
    public static void TestCallAble() throws InterruptedException, ExecutionException{
    	//提交一个 Runnable 任务用于执行，并返回一个表示该任务的 Future。
    	//该 Future 的 get 方法在成功 完成时将会返回 null
		ExecutorService exesService = Executors.newFixedThreadPool(1);
		//新建一个线程类
		TestCallable t1 = new TestCallable();
		//启动线程并返回值
		Future<Integer> future = exesService.submit(t1);
		//取回返回值
		int result = future.get();
		System.out.println(result);
		//停止服务
		exesService.shutdown();
    }
    /**
     * 
     * 描述：实现Callab接口实现龟兔赛跑的模拟
     * @author gt
     * @created 2016年4月11日 下午9:59:25
     * @since 
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public static void TestRabbitAndTortoise() throws InterruptedException, ExecutionException{
    	//起一个线程池，线程池为2
    	ExecutorService executorService = Executors.newFixedThreadPool(2);
    	//实际线程1
    	Animal tortoise = new Animal("gutao", 1000);
    	//实际线程2
    	Animal rabbit = new Animal("nibei", 500);
    	//启动第一个线程，并但会Future对象
    	Future<Integer> future1 = executorService.submit(tortoise);
    	//启动第二个线程，并返回Future对象
    	Future<Integer> future2 = executorService.submit(rabbit);
    	Thread.sleep(2000);
    	tortoise.setFlag(false);
    	rabbit.setFlag(false);
    	int f1 = future1.get();
    	int f2 = future2.get();
    	System.out.println("乌龟跑了："+f1);
    	System.out.println("兔子跑了："+f2);
    	executorService.shutdown();
    }
}
/**
 * 
 * 描述：实现Callable接口
 * @author gt
 * @created 2016年4月11日 下午10:00:09
 * @since
 */
class Animal implements Callable<Integer>{
	private String name;//名称
	private long time;//停顿时间
	private boolean flag = true;//是够循环
	private int step = 0;//走过的步数
    public Animal(){
	   
    }
    public Animal(String name,long time){
    	this.name = name;
    	this.time = time;
    }
	@Override
	public Integer call() throws Exception {
		while (flag) {
			Thread.sleep(time);//进行延时模拟速度
			step++;
		}
		return step;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}
	
	
}
