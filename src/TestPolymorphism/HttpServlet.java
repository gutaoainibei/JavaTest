package TestPolymorphism;


public class HttpServlet {
     public void doGet(){
    	 System.out.println(this.getClass().getName());
    	 Service();
     }
     public void Service(){
    	 System.out.println("HttpServlet ----");
     }
}
