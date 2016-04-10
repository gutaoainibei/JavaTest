package Thread;

public class ThreadTest1 implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("gutao ai nibei");

		}
	}
   public static void main(String[] args) {
	ThreadTest1 test1 = new ThreadTest1();
	Thread thread = new Thread(test1);
	thread.start();
	for (int i = 10; i > 0; i--) {
		System.out.println("倒计时"+i);
	}

}
}
