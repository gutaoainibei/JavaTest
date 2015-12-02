package TestThis;


public class Student {
	//静态变量和方法属于类方法和变量，普通的属于对象属性和方法，对象可以调用静态方法和普通方法
	//但是类只能调用类方法和类属性，静态static修饰都属于类的方法和属性，当对象被新建的时候
	//智慧初始化对象属性，静态模块和方法已经属性都会忽略，代码和静态变量以及常量都放在方法区中
	//类信息会被首先加载到方法去中，新建对象时，对象会根据已有的类信息，新建对象，对象存放在堆中
	//栈中存放的是局部变量，栈中是后进先出空间连续，堆中放置new出来的对象，空间不连续，方法区其实也是堆
    private String name;
    private int id;
    static int idnum=10;
    public Student(int id ,String name){
    	//Constructor call must be the first statement in a constructor
    	//在一个构造参数中调用另外一个构造函数必须放在首位
    	this(id);
    	System.out.println("构造双参的对象");
    	this.name = name;
    	this.id =id;
    }
    //在构造函数中，this代表当前初始化的对象
    public Student(int id){
    	this();
    	System.out.println("构造有一个id的对象");
    }
    public Student(){
       // 递归调用构造函数,Recursive constructor invocation Student(int)
    	//构造器重不允许出现递归调用
    	System.out.println("构造无参对象");
    }
    public static void println(){
    	System.out.println(idnum);
    } 
    //在方法中，this代表调用该方法的对象，this可以隔两层传递，比如子类调用了父类的父类的某个方法，此时的this还是本子类
    public void test(){
    	System.out.println(this.name);
    }
}
