package TestGeneric;

/**
 * 
 * 描述：测试泛型类的继承
 * 
 * @author gt
 * @created 2016年2月21日 下午4:09:11
 * @since
 */

public abstract class StudyGeneric<T1, T2> {
	T1 age;

	public abstract void test(T2 t2);
}

// 全部保留
class StudyGenericChild2<T1, T2> extends StudyGeneric<T1, T2> {
	@Override
	public void test(T2 t2) {
		// TODO Auto-generated method stub

	}

}

// 不保留，这就是泛型的擦除
// 擦除之后，类型类似于Object
class StudyGenericChild1<T1, T2> extends StudyGeneric {

	@Override
	public void test(Object t2) {

	}

}

// 部分保留
class StudyGenericChild3<T1, String> extends StudyGeneric<T1, Integer> {

	@Override
	public void test(Integer t2) {

	}

}

class StudyGenericChild6<T1, Integer> extends StudyGeneric<T1, String> {

	@Override
	public void test(String t2) {

	}

}

// 全不保留
class StudyGenericChild4<String, Integer> extends StudyGeneric<String, Integer> {

	@Override
	public void test(Integer t2) {

	}

}