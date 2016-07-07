package designPattern.Factory.MethodFactory;

public class Client1 {
    public static void main(String[] args) {
		Car benci = BenciFactory.createBenci();
		Car audi = AudiFactory.createAudi();
		benci.run();
		audi.run();
	}
}
