package MyLinkedList;

import com.mysql.jdbc.UpdatableResultSet;


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
   public Object get(int index){
	   checkRange(index);
	   Node node = null;
	   if(first!=null){
		   int i = 0;
		   node = first;
		   while (i<index) {
			node = node.getNext();
			i++;
		}
	   } 
	   return node.getNow();
   }
   public void checkRange(int index){
	   if(index<0 || index>size-1){
   		try {
   		  throw	new Exception("集合溢出");
			} catch (Exception e) {
				e.printStackTrace();
			}
   	}
   }
   public void remove(int index){
       checkRange(index);
       Node node = null;
       if(first!=null){
           int i =0;
           while(i < index){
               node = first.getNext();
               i++;
           }
           Node up = node.getPrevious();
           Node down = node.getNext();
           up.setNext(down);
           down.setPrevious(up);
           size--;
       }
   }
   public static void main(String[] args) {
	   MyLinkedList list = new MyLinkedList();
	   list.add("aaa");
	   list.add("bbb");
	   list.add("ccc");
	   System.out.println(list.size());
	   System.out.println(list.get(1));
	   list.remove(1);
	   System.out.println(list.get(1));
}
}
