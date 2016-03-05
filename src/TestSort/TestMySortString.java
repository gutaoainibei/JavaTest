package TestSort;

public class TestMySortString implements Comparable<String>{
	private final static String mystring = "gutao";
	private String name = "nibei";
	public static void main(String[] args) {
		//如果一个从开头开始是另外一个的字串，则返回字符串的长度差
		//这里字符串比较的时候，会把第一个不同的字符的差返回，有0，-1，1三种状态
		//0为相等，正数为大于，负数为小于
		
        String[] strings = {"asd","sdfc","avd","d"};
        for (int i = 0; i < strings.length; i++) {
        	 for (int j = 0; j < strings.length-1-i; j++) {
     			if(strings[j].compareTo(strings[j+1])>0){
     				String temp = strings[j];
     				strings[j] = strings[j+1];
     				strings[j+1] = temp;
     			}
     		}
		}
        for (String string : strings) {
			System.out.print(string+" ");
		}
        System.out.println();
        String[] strings1 = {"a","abc","ab","abcd"};
        for (int i = 0; i < strings1.length; i++) {
        	 for (int j = 0; j < strings1.length-1-i; j++) {
     			if(strings1[j].compareTo(strings1[j+1])>0){
     				String temp = strings1[j];
     				strings1[j] = strings1[j+1];
     				strings1[j+1] = temp;
     			}
     		}
		}
        for (String string : strings1) {
			System.out.print(string+" ");
		}
        System.out.println();
        System.out.println("========比较字符串==========");
        String s1 = "14";
        String s2 = "114";
        System.out.println(s1.compareTo(s2));
        TestMySortString test1 = new TestMySortString();
        test1.name = "gutaoainibei";
        System.out.println(test1.compareTo(s1));//实现自己的string比较
	}

	@Override
	public int compareTo(String o) {
		int len1 = name.length();
		int len2 = o.length();
		return len2-len1;
	}

}
