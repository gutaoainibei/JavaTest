package MyArrayList;

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
    //判断是否为空
    public boolean isEmpty() {
        return size == 0;
    }
    public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		list.add("gutao");
		list.add("nibei");
		Human human = new Human("luoming");
		list.add(human);
		System.out.println(list.size());
		System.out.println(list.get(1));
		Human human2 = (Human)list.get(2);
		System.out.println(human2.getName());
		System.out.println(list.lastIndexOf("nibei"));
		System.out.println(list.indexOf("nibei"));
	    list.set(0, "gt");
	    System.out.println(list.get(0));
	}
}
//src the source array.
//srcPos starting position in the source array.
//dest the destination array.
//destPos starting position in the destination data.
//length the number of array elements to be copied.
//System.arraycopy(src, srcPos, dest, destPos, length);
//这里我讲一下上面的实现过程，也将一下StringBuilder的insert的实现过程
//首先我们会对字符数组进行一个扩容，然后把原有的数据copy到新的数组中
//然后再copy一次，这一次是挪动后面的序列（比如起先说是aadd,要在第二个a后面插入一个aa,则先变成aa__dd）
//然后再添加aa