package designPattern.Observer1;

import java.util.Observable;
import java.util.Observer;

/**
 * 
 * 描述：观察者
 * 
 * @author gt
 * @created 2016年7月31日 下午12:47:10
 * @since
 */
public class Observertest implements Observer {
	int mystate;

	@Override
	public void update(Observable o, Object arg) {
		mystate = ((Observerzable) o).getState();
	}

	public int getMystate() {
		return mystate;
	}

	public void setMystate(int mystate) {
		this.mystate = mystate;
	}

}
