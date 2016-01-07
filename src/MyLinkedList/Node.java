package MyLinkedList;

public class Node {
	private Node previous;
	private Object now;
	private Node next;
	public Node getPrevious() {
		return previous;
	}
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	public Object getNow() {
		return now;
	}
	public void setNow(Object now) {
		this.now = now;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}

	

}
