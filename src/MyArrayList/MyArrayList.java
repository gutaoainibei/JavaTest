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
    Object[] value;
    int size;
    public Object add(){
//    	src the source array.
//    	srcPos starting position in the source array.
//    	dest the destination array.
//    	destPos starting position in the destination data.
//    	length the number of array elements to be copied.
//    	System.arraycopy(src, srcPos, dest, destPos, length);
    	//这里我讲一下上面的实现过程，也将一下StringBuilder的insert的实现过程
    	//首先我们会对字符数组进行一个扩容，然后把原有的数据copy到新的数组中
    	//然后再copy一次，这一次是挪动后面的序列（比如起先说是aadd,要在第二个a后面插入一个aa,则先变成aa__dd）
    	//然后再添加aa
		return size;
    	
    }
}
