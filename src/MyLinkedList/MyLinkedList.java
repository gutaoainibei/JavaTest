package MyLinkedList;


public class MyLinkedList {
   private Node first;
   private Node last;
   int size;
   public int size(){
	   return size;
   }
   public void add(Object obj){
	   Node node = new Node();
	   if(first==null){
		   node.setPrevious(null);
           node.setNow(obj);
           node.setNext(null);
           first = node;
           last = node;
	   }else{

		   last.setNext(node);
		   
		   node.setPrevious(last);
		   node.setNow(obj);
		   node.setNext(null);
		   
		   last = node;
		  
	   }
	   size++;
   }
   public static void main(String[] args) {
	   MyLinkedList list = new MyLinkedList();
	   list.add("aaa");
	   list.add("bbb");
	   System.out.println(list.size());
}
}
