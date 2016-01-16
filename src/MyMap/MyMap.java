package MyMap;

import java.util.HashMap;

public class MyMap {
    private MyEntry[] entry = new MyEntry[2];
    private int size;
    public int size(){
    	return this.size;
    }
    public void put(Object key,Object value){
    	if(size<entry.length){
    		entry[size]=new MyEntry(key, value);
    		size++;
    	}else{
    		MyEntry[] newentry = new MyEntry[2*size+1];
    		System.arraycopy(entry, 0, newentry, 0, entry.length);
    		newentry[size]=new MyEntry(key, value);
    		entry = newentry;
    		size++;
    	}
    }
    public Object get(Object key){
    	for(int i = 0;i<entry.length;i++){
	    	if(entry[i].key.equals(key)){
	    	   return entry[i].value;	
	    	}
    	}
    	return null;
    }
	public static void main(String[] args) {
         MyMap myMap = new MyMap();
         myMap.put("key1", "gutao");
         myMap.put("key2", "nibei");
         System.out.println(myMap.size());
         myMap.put("key3", "luoming");
         System.out.println(myMap.get("key2"));
         System.out.println(myMap.get("key3"));
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