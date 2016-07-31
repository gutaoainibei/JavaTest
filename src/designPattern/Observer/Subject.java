package designPattern.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 描述：主题
 * 
 * @author gt
 * @created 2016年7月31日 上午11:40:55
 * @since
 */
public class Subject {
	private List<Observer> list = new ArrayList<Observer>();

	public void register(Observer observer) {
		list.add(observer);
	}

	public void remove(Observer observer) {
		list.remove(observer);
	}
	public void notifyAllObserver(){
		for (Observer obj : list) {
			obj.update(this);
		}
	}
}
