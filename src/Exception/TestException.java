package Exception;

import java.util.ArrayList;
import java.util.List;


public class TestException {
   public static void main(String[] args) {
	System.out.println("测试异常类");
	List list = new ArrayList();
	if(list.isEmpty()){
		list = new ArrayList();
	}
	System.out.println(list.toArray().toString());
}
}
