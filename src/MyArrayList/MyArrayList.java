package MyArrayList;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
* @ClassName: MyArrayList 
* @Description: TODO(自己定义的集合类) 
* @author gutao 
* @date 2015年12月13日 下午9:35:56 
*
 */
public class MyArrayList {
	//存储元素的数组对象
    private Object[] value;
    //数组当前元素个数
    private int size;
    //构造器
    public MyArrayList(){
    	this(10);
    }
    public MyArrayList(int size){
    	this.value = new Object[size];
    }
    //获取数组长度
    public int size(){
    	return this.size;
    }
    //添加元素，指定位置
    public void add(int index,Object obj){
    	  RangeCheck(index);
    	  int length = size-index;
    	  System.arraycopy(value, index, value, index+1, length);
    	  value[index]=obj;
    	  size++;
    }
    //添加元素
    public void add(Object obj){
    	value[size] = obj;
    	size++;
    	if(size >= value.length){
    	   int count = size*2;
    	   Object[] newvalue = new Object[count];
    	   for (int i=0; i<value.length; i++) {
			  newvalue[i] = value[i];
		   }
    	   this.value = newvalue;
    	}
    }
    //使index位置的元素被替换成obj
    public void set(int index,Object obj){
    	RangeCheck(index);
    	this.value[index] = obj;
    }
    //获取最后一个传入对象的索引
    public int lastIndexOf(Object obj){
    	if(obj == null){
    		for(int i = size-1; i>0; i--)
    			if(value[i] == null)
    				return i;	
    	}else{
    		for(int i = size-1; i>0; i--)
    			if(obj.equals(value[i]))
    				return i;
    	}
    	return -1;
    	
    }
    //通过索引获取到元素
    public Object get(int index){
    	RangeCheck(index);
    	return value[index];
    }
    //获取第一个传入对象的数组中的索引
    public int indexOf(Object obj){
    	if(obj == null){
    		for(int i = 0; i<size-1; i++)
    			if(value[i] == null)
    				return i;	
    	}else{
    		for(int i = 0; i<size-1; i++)
    			if(obj.equals(value[i]))
    				return i;
    	}
    	return -1;
    }
    
    //检测是否在数组长度范围内
    public void RangeCheck(int index){
    	if(index<0 || index>size-1){
    		try {
    		  throw	new Exception("集合溢出");
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    }
    //删除指定对象
    public void remove(Object obj){
    	for(int i =0;i<size;i++){
    		if(obj.equals(value[i])){
    			remove(i);
    		}
    	}
    }
    //删除指定对象
    public void remove(int index){
    	RangeCheck(index);
    	int length = size-index-1;
    	System.arraycopy(value, index+1, value, index, length);
    	value[--size]=null;
    }
    //判断是否为空
    public boolean isEmpty() {
        return size == 0;
    }
    public Iterator iterator(){
    	return new MyIterator();
    }
    private class MyIterator<E> implements Iterator<E>{
        private int coursor = -1;
        
		public boolean hasNext() {
			boolean sign = coursor+1 < size;
			return sign;
		}

		public E next() {
			coursor++;
			return (E)value[coursor];
		}

		public void remove() {
			// TODO Auto-generated method stub
			
		}
    	
    }
    public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		list.add("gutao");
		list.add("nibei");
		//Human human = new Human("luoming");
		//list.add(human);
		list.add(1, "gutaoainibei");
	 
	    System.out.println(list.get(1));
	    System.out.println(list.size());
	    for(int i = 0 ;i < list.size ; i++){
	    	System.out.println(list.get(i));
	    }
	    list.remove(1);
	   System.out.println("========================");
       Iterator<String> myIterator = list.iterator();
       int count = 0;
       while(myIterator.hasNext()){
    	   count++;
    	   System.out.println(myIterator.next());
       }
	}
}