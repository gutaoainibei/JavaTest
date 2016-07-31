package designPattern.memento;
/**
 * 
 * 描述：负责人类
 * @author gt
 * @created 2016年7月31日 下午1:12:45
 * @since
 */
public class CareTaker {
    EmployeeMemento memento;

	public EmployeeMemento getMemento() {
		return memento;
	}

	public void setMemento(EmployeeMemento memento) {
		this.memento = memento;
	}
    
}
