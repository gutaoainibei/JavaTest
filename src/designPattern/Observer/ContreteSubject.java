package designPattern.Observer;

public class ContreteSubject extends Subject {
       int state ;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		notifyAllObserver();
	}
       
}
