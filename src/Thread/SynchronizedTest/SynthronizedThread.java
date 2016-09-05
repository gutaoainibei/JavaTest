package Thread.SynchronizedTest;


/**
 * 
 * 描述：测试锁，同步
 *     1.同步块：synchronized(引用类型|this|类.class){}
 *     2.同步方法 ：用synchronized关键词修饰的方法
 *     同步加锁时容易碰到几个问题，锁定对象不对，锁定范围太小导致没有达到效果
 *     锁定范围太大，容易影响性能
 * @author gt
 * @created 2016年4月15日 下午11:20:22
 * @since
 */
public class SynthronizedThread {
	public static void main(String[] args) {
		 Thread12306 t12306 = new Thread12306();
	     Thread t1 = new Thread(t12306, "顾涛");
	     Thread t2 = new Thread(t12306,"倪贝");
	     Thread t3 = new Thread(t12306, "顾倪");
	     t1.start();
	     t2.start();
	     t3.start();
	}
  
   
}
class Thread12306 implements Runnable{
	  private boolean flag = true;
	    private int num = 20;
		public void run() {
			while (flag) {
				test7();
			}
		}
		//锁定类模板，这样也可以达到同样的效果
		  public void test7() {
			  synchronized(Thread12306.class){
				if (num <= 0 ) {//如果票没了，就停止循环，返回
					flag = false;
					return;
				 }
				 try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					 System.out.println(Thread.currentThread().getName()+"抢到第"+num--+"张票");
				}
		}
		//锁定对象有误
		  public void test6() {
			  synchronized((Integer)num){
				if (num <= 0 ) {//如果票没了，就停止循环，返回
					flag = false;
					return;
				 }
				 try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					 System.out.println(Thread.currentThread().getName()+"抢到第"+num--+"张票");
				}
		}
		//锁定范围不正确
		  public void test5() {
				if (num <= 0 ) {//如果票没了，就停止循环，返回
					flag = false;
					return;
				 }
				synchronized(this){
					 try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					 System.out.println(Thread.currentThread().getName()+"抢到第"+num--+"张票");
				}
		}
		//锁定范围不正确
		public void test4() {
			synchronized(this){
				 if (num <= 0 ) {//如果票没了，就停止循环，返回
					flag = false;
					return;
				 }
			}
			 try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			 System.out.println(Thread.currentThread().getName()+"抢到第"+num--+"张票");
		}
		//线程安全，第一种方式，通过同步块来确定,与test2效果一样
		public void test3() {
			synchronized(this){
				 if (num <= 0 ) {//如果票没了，就停止循环，返回
					flag = false;
					return;
				 }
				 try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				 System.out.println(Thread.currentThread().getName()+"抢到第"+num--+"张票");
		   }
		}
		//线程安全，第二种方式，通过关键字synchronized修饰方法
		public synchronized void test2() {
				 if (num <= 0 ) {//如果票没了，就停止循环，返回
					flag = false;
					return;
				 }
				 try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				 System.out.println(Thread.currentThread().getName()+"抢到第"+num--+"张票");
		}
		//线程不安全
		public void test1() {
			 if (num <= 0 ) {
				flag = false;
			 }
			 try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 System.out.println(Thread.currentThread().getName()+"抢到第"+num--+"张票");
		}
}