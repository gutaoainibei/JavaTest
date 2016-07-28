package designPattern.Mediator;

import java.util.HashMap;
import java.util.Map;

public class President implements Mediator {
    Map<String, Department> map = new HashMap<String, Department>();
	@Override
	public void command(String name) {
          map.get(name).selfAction();
	}

	@Override
	public void register(String name, Department department) {
           map.put(name, department);
	}

}
