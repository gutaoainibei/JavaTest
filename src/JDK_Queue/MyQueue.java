package JDK_Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue<E> {
    private Deque<E> container = new ArrayDeque<E>();
    private int size;
    public MyQueue(){
    	this(5);
    }
    public MyQueue(int size){
    	this.size = size;
    }
    //压栈
    public boolean push(E e){
    	if(container.size()+1>size){
    		return false;
    	}
    	return container.offerLast(e);
    }
    //弹出,先进后出
    public E pop(){
    	return container.pollLast();
    }
    //获取
    public E peek(){
    	return container.peekLast();
    }
    //获取队列中现在的数目
    public int size(){
    	return this.container.size();
    }
    public static void main(String[] args) {
		MyQueue<String> myQueue = new MyQueue<String>(6);
		myQueue.push("gutao.com");
		myQueue.push("nibei.com");
		myQueue.push("gutaoainibei.com");
		System.out.println("队列现在的数目："+myQueue.size());
		String popString = null;
		while((popString=myQueue.pop())!=null){
			System.out.println(popString);
		}
	}
}
