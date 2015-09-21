package testInterfaceorAbstract;

public class TestArrayRefrence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int[] a1 = {1,2,3};
         int[] a2;
         a2 = a1;
         for (int i = 0; i < a2.length; i++) {
			System.out.println(a2[i]);
		 }
	}

}
