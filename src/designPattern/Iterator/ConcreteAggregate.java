package designPattern.Iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 描述：聚合对象集合
 * @author gt
 * @created 2016年7月26日 下午11:54:32
 * @since
 */
public class ConcreteAggregate {
     List<Object> list = new ArrayList<Object>();
     
     public void removeObject(Object obj){
    	 list.remove(obj);
     }
     public void addObject(Object obj){
    	 list.add(obj);
     }
     public MyIterator getIterator(){
    	 return new ConcreteIterator();
     }
     private class ConcreteIterator implements MyIterator{
        private int cursor;
		public void first() {
			cursor = 0;
		}

		public void next() {
			if(cursor < list.size()){
			     cursor++;
			}
		}

		public boolean hasNext() {
			if(cursor < list.size()){
				return true;
			}
			return false;
		}

		public boolean isFirst() {
			return cursor == 0 ? true : false;
		}

		public boolean isLast() {
			return cursor == (list.size()-1) ? true : false;
		}

		public Object getCurrentObj() {
			return list.get(cursor);
		}
    	 
     }
}
