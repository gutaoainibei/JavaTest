package MyLinkedList;


/**
 * 
* @ClassName: MyLinkedList 
* @Description: TODO(自己定义的链表类) 
* @author gutao 
* @date 2016年1月11日 下午11:36:08 
*
 */
public class MyLinkedList {
   private Node first;
   private Node last;
   private int size;
   /**
    * 
   * @Title: size 
   * @Description: TODO(获得链表的长度) 
   * @param @return    设定文件 
   * @return int    返回类型 
   * @throws
    */
   public int size(){
	   return size;
   }
   /**
    * 
   * @Title: add 
   * @Description: TODO(在末尾添加一个对象) 
   * @param @param obj    设定文件 
   * @return void    返回类型 
   * @throws
    */
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
   /**
    * 
   * @Title: get 
   * @Description: TODO(获得指定处，存放的对象) 
   * @param @param index
   * @param @return    设定文件 
   * @return Object    返回类型 
   * @throws
    */
   public Object get(int index){
	   checkRange(index);
	   Node node = getNode(index);
	   return node.getNow();
   }
   /**
    * 
   * @Title: checkRange 
   * @Description: TODO(检查是否在链表范围内) 
   * @param @param index    设定文件 
   * @return void    返回类型 
   * @throws
    */
   public void checkRange(int index){
	   if(index<0 || index>size-1){
   		try {
   		  throw	new Exception("集合溢出");
			} catch (Exception e) {
				e.printStackTrace();
			}
   	}
   }
   /**
    * 
   * @Title: getNode 
   * @Description: TODO(获得对应节点) 
   * @param @param index
   * @param @return    设定文件 
   * @return Node    返回类型 
   * @throws
    */
   public Node getNode(int index){
	   Node node = null;
	   if(first!=null){
		   node = first;
		   int i = 0;
		   while (i<index) {
			node = node.getNext();
			i++;
		   }
	   } 
 	   return node;
   }
   /**
    * 
   * @Title: remove 
   * @Description: TODO(删除指定节点) 
   * @param @param index    设定文件 
   * @return void    返回类型 
   * @throws
    */
   public void remove(int index){
       checkRange(index);
       Node node = getNode(index);
       Node up = node.getPrevious();
       Node down = node.getNext();
       if(index == 0){
    	   first = down;
       }else if(index == (size-1)){
    	   last = up;
       }else{
    	   up.setNext(down);
           down.setPrevious(up);
       }
       size--;
   }
   /**
    * 
   * @Title: add 
   * @Description: TODO(这里用一句话描述这个方法的作用) 
   * @param @param args    设定文件 
   * @return void    返回类型 
   * @throws
    */
   public void add(int index,Object obj){
	   checkRange(index);
	   Node temp = new Node();
	   temp.setNow(obj);
	   Node node = getNode(index);
	   Node up = node.getPrevious();
	   temp.setPrevious(up);
	   up.setNext(temp);
	   temp.setNext(node);
	   node.setPrevious(temp);
	   size++;
   }
   public static void main(String[] args) {
	   MyLinkedList list = new MyLinkedList();
	   list.add("aaa");
	   list.add("bbb");
	   list.add("ccc");
	   list.add(1, "gutao");
	   System.out.println(list.get(0));
	   System.out.println(list.get(1));
	   System.out.println(list.get(2));
	   System.out.println(list.get(3));
	   list.remove(2);
	   System.out.println(list.get(2));
	   list.remove(2);
	   System.out.println(list.get(1));
}
}
