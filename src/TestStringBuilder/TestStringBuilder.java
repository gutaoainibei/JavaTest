package TestStringBuilder;

public class TestStringBuilder {
    public static void main(String[] args) {
    	//这里StringBuilder是会new一个字符数组长度为16
    	StringBuilder stringBuilder0 = new StringBuilder();
    	//这里StringBuilder是会new一个字符数组长度为16+3
		StringBuilder stringBuilder1 = new StringBuilder("aaa");
		//这里StringBuilder是会new一个字符数组长度为32的
		StringBuilder stringBuilder2 = new StringBuilder(32); 
		//这里只new了一个对象
		//默认的16不够，会等到不够是执行扩容，新数组的长度是（原来的length）*2+2，成为新的长度
		for(int i = 0;i<1000;i++){
			stringBuilder0.append(""+i);
		}
		//这里new了1002个对象"aa",加上new的一个对象，加1000,这就是可变和不可变的区别
		
		String str1 = new String("aa");
		for(int i = 0;i<1000;i++){
			str1+=i;
		}
	}
}
