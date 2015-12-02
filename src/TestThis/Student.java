package TestThis;


public class Student {
    private String name;
    private int id;
    static int idnum=10;
    public Student(int id ,String name){
    	this();
    	//this(id);
    	this.name = name;
    	this.id =id;
    }
    public Student(int id){
    	System.out.println("构造有一个id的对象");
    }
    public Student(){
    	System.out.println("构造无参对象");
    }
    public static void println(){
    	System.out.println(idnum);
    } 
    public void test(){
    	System.out.println(this.name);
    }
}
