package MyMap;

import java.util.HashMap;
import java.util.Map;

public class MyMap {
    private MyEntry[] entry = new MyEntry[2];
    private int size;
    public int size(){
    	return this.size;
    }
    public void put(Object key,Object value){
    	if(size>0){
    	for(int i = 0;i < size; i++){
    	if(entry[i].key.equals(key)){
    	      entry[i].value = value;
    	}else{
    		if(size<entry.length){
        		entry[size] = new MyEntry(key, value);
        		size++;
        	}else{
        		MyEntry[] newentry = new MyEntry[2*size+1];
        		System.arraycopy(entry, 0, newentry, 0, entry.length);
        		newentry[size]=new MyEntry(key, value);
        		entry = newentry;
        		size++;
        	}
    	}
    	}
    	}else if(size == 0){
    		entry[size] = new MyEntry(key, value);
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
         myMap.put("key1", "guta");
         myMap.put("key1", "nibei");
         myMap.put("key2", "luoming");
         System.out.println(myMap.size());
         System.out.println(myMap.get("key1"));
         System.out.println(myMap.get("key2"));
         Map map = new HashMap();
         map.put("key", "gutao");
         map.put("key", "nibei");
         System.out.println(map.size());
         System.out.println(map.get("key"));
    
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