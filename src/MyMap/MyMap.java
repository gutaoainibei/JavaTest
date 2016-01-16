package MyMap;

import java.util.HashMap;

public class MyMap {
    private MyEntry[] entry = new MyEntry[10];
	public static void main(String[] args) {

	}

}
class MyEntry{
	Object key;
	Object value;
	public MyEntry(Object key,Object value){
		this.key = key;
		this.value =value;
	}
}