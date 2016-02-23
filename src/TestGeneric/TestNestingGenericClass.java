package TestGeneric;
/**
 * 
 * 描述：测试泛型的嵌套
 * @author gt
 * @created 2016年2月23日 下午11:13:11
 * @since
 */
public class TestNestingGenericClass {
    public static void main(String[] args) {
		Classroom<Student<String>> classroom = new Classroom<Student<String>>();
	    Student<String> stu = new Student<String>();
	    stu.setName("gutao");
		classroom.setStu(stu);
		System.out.println(classroom.getStu().getName());
    }
}
