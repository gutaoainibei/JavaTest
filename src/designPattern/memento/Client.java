package designPattern.memento;
/**
 * 
 * 描述：测试备忘录模式
 * @author gt
 * @created 2016年7月31日 下午1:16:11
 * @since
 */
public class Client {
   public static void main(String[] args) {
	   CareTaker careTaker = new CareTaker();
	   Employee employee = new Employee("gutao", 23, 1000000);
	   System.out.println("姓名："+employee.getName()+",年纪："+employee.getAge()+",月薪："+employee.getSalary());
	   careTaker.setMemento(employee.getMenmeto());//这个类可以看作是磁盘
	   employee.setName("nibei");
	   employee.setAge(22);
	   employee.setSalary(100000);
	   System.out.println("姓名："+employee.getName()+",年纪："+employee.getAge()+",月薪："+employee.getSalary());
       employee.recovery(careTaker.getMemento());
	   System.out.println("姓名："+employee.getName()+",年纪："+employee.getAge()+",月薪："+employee.getSalary());

}
}
