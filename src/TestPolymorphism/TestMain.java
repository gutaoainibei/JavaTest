package TestPolymorphism;

public class TestMain {
   public static void main(String[] args) {
	   //此处调用的是Myservlet的Service而不是HttpServlet的Service
	   //因为此处的this指向Myservlet
	HttpServlet myServlet = new MyServlet();
	myServlet.doGet();
}
}
