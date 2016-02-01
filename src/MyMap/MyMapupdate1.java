package MyMap;

import java.util.HashMap;
import java.util.Map;

import MyLinkedList.MyLinkedList;
/**
 * 
 * 描述：自己实现的map对象
 * @author gt
 * @created 2016年1月17日 下午11:16:07
 * @since
 */
public class MyMapupdate1 {
	//初始化存储值，map底层是通过数组和链表实现的
    private MyLinkedList[] entrylist = new MyLinkedList[99];
    private int size;
    public int size(){
    	return this.size;
    }
    /**
     * 
     * 描述：向map中添加值
     * @author gt
     * @created 2016年1月17日 下午11:22:07
     * @since 
     * @param key
     * @param value
     */
    public void put(Object key,Object value){
    	//通过传进来的对象new一个包含传进来键值对的对象
       MyEntry entry = new MyEntry(key, value);
       //获取hash码对应的取余德值
       int index =  hash(key)%entrylist.length;
       //判断指定处是否存放了链表，如果为空就添加一个新链表，否则在原来的链表后面添加（如果key没有重复的话）
       if(entrylist[index]==null){
    	   //new出一个链表对象
	       MyLinkedList mylist = new MyLinkedList();
	       //存放新的链表
	       entrylist[index] = mylist;
	       //在新链表中添加了值
	       mylist.add(entry);
	       size++;
       }else{
    	   //如果已经存在链表，那么就直接在已经有的地方添加
    	   MyLinkedList temLinkedList = entrylist[index];
    	   for(int i = 0; i < temLinkedList.size();i++){
    		   //获取指定位置的链表
    		   MyEntry tempentry = (MyEntry)temLinkedList.get(i);
    		   //判断是否有重复的，有重复直接覆盖
	    	   if(tempentry.key.equals(key)){
	    		   tempentry.value = value;
	    		   return;
	    	   }
    	   }
    	   entrylist[index].add(entry);
       }
    }
    /**
     * 
     * 描述:获取指定元素
     * @author gt
     * @created 2016年1月17日 下午11:22:42
     * @since 
     * @param key
     * @return
     */
    public Object get(Object key){
    	int index = hash(key)%entrylist.length;
        MyLinkedList tempLinkedList = entrylist[index];
    	if(entrylist[index] != null){
    			for(int i = 0 ;i < tempLinkedList.size(); i++){
    				MyEntry temEntry = (MyEntry)tempLinkedList.get(i);
    				if(temEntry.key.equals(key)){
    					return temEntry.value;
    				}
    		}
    	}
    	return null;
    }
    public int hash(Object key){
    	int i = key.hashCode();
    	i = i < 0 ? -i : i;
    	return i;
    }
	public static void main(String[] args) {
         MyMapupdate1 myMap = new MyMapupdate1();
         myMap.put("key", "gutao");
         myMap.put("key1", "nibei");
         System.out.println(myMap.size);
         System.out.println(myMap.get("key"));
         Map map = new HashMap();
         map.put("key", "gutao");
         map.put("key2", "nibei");
         System.out.println(map.size());
         System.out.println(map.get("key2"));
	}

}
