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
 * extends：泛型的上限<= ，即子类
 * 1.一般用于限制操作
 * 2.不能使用在添加数据上面，一般都是读取操作
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
	   //这里不能往list里面添加元素，因为我们继承Fruit我们无法确定list里面的元素是那个类型
	   //前一个类型，是不是要比后一个类型范围更大，所以编译根本无法确定
	   //The method add(capture#1-of ? extends Fruit) in the type List<capture#1-of ? extends Fruit> 
	   // is not applicable for the arguments (Apple)
	   //list.add(new Apple());	
	}
	public static void test1(List<? super Fruit> list){
		//这里我们可以加比Fruit的子类，因为上限是确定了得，所以和上面相比，我们不存在编译的不确定性和错误性
		list.add(new Fruit());
		list.add(new Apple());
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