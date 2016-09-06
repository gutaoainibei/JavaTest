package test;

public class TTT1 implements t1 {

	public void testst() {
       System.out.println("gutao");
	}

	public String getName() {
		return "gutao";
	}
    public static void main(String[] args) {
    	TTT1 tt = new TTT1();
	    tt.testst();
	    System.out.println(tt.getName());
	    t1 y = new TTT1();
	    y.testst();
    }
} 
