package Testrefrence;

public class Product {
	int i;
   public Product() {
	
   }
   public Product(int i) {
		this.i = i;
   }
   public static int testobj(Product p){
//	   System.out.println("testObj--------"+p.i);
	   p.i++;
	   return p.i;
   }
   public static int testobjdata(int i){
	   i++;
	   System.out.println("test："+i);
	   return i;
   }
   public static void main(String[] args) {
	 Product p1 = new Product(7);
	 System.out.println("main:"+p1.i);
	 testobj(p1);
	 p1.i++;
     System.out.println(testobj(p1));
	   testobjdata(p1.i);
	   System.out.println(p1.i);
	   
//	Product p = new Product();
//	Product p1 = new Product();
//	System.out.println(p);
//	System.out.println(p1);
//	System.out.println("-----------------");
//	p1 = p;
//	System.out.println("--p的值："+p);
//	System.out.println("--p1的值"+p1);
//	
//	Product p = new Product();
//	Product p1 = new Product();
//	p1 = p;
//	System.out.println("--p的值："+p.i);
//	System.out.println("--p1的值"+p1.i);
//	System.out.println("--------更改后-------------");
//	p.i++;
//	System.out.println("--p的值："+p.i);
//	System.out.println("--p1的值"+p1.i);
   }
}

