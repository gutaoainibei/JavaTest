package designPattern.Observer1;

import java.util.Observable;
/**
 * 
 * 描述：被观察对象
 * @author gt
 * @created 2016年7月31日 下午12:40:40
 * @since
 */
public class Observerzable extends Observable{
      private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		setChanged();//目标已经更改
		notifyObservers(state);//通知所有的观察者
	}
      
}
