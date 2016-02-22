package TestGeneric;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 描述：测试泛型上下限
 * 
 * @author gt
 * @created 2016年2月22日 下午11:08:00
 * @since
 */
public class TestGenericMax {
	public static void main(String[] args) {
       List<Apple> list1 = new ArrayList<Apple>();
       test(list1);
       List<Fruit> list2 = new ArrayList<Fruit>();
       test(list2);
       List<Object> list3 = new ArrayList<Object>();
       //test(list3);
       
    		   
	}
	public static void test(List<? extends Fruit> list){
		
	}
}

class Fruit {

}

class Apple extends Fruit {

}

class Pear extends Fruit {

}

class FujiApple extends Apple {

}