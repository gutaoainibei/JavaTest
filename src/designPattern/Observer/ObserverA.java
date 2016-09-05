package designPattern.Observer;

public class ObserverA implements Observer {
	int myState;
	ContreteSubject subject;
	public void update(Subject subject) {
		myState = ((ContreteSubject) subject).getState();
		this.subject = (ContreteSubject) subject;
	}

	public int getMyState() {
		return myState;
	}

	public void setMyState(int myState) {
		this.myState = myState;
	}

	public ContreteSubject getSubject() {
		return subject;
	}

	public void setSubject(ContreteSubject subject) {
		this.subject = subject;
	}
}
