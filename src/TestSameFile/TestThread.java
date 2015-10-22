package TestSameFile;

public class TestThread extends Thread implements Runnable{
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("gutao");
	}
	public static void main(String[] args) {
		System.out.println("main gutao");
		TestThread t = new TestThread();
		Thread thread1 = new Thread(t);
		t.start();
		thread1.start();
	   
	}
}
