package designPattern.build;
/**
 * 
 * 描述：测试建造者模式
 * @author gt
 * @created 2016年7月10日 下午11:50:02
 * @since
 */
public class Client {
   public static void main(String[] args) {
	AirShipDirector airShipDirector = new AirShipDirectorImpl(new AirShipBuilderImpl());
	AirShipModle airShipModle = airShipDirector.createAirShipModle();
	System.out.println(airShipModle.getEngine().getName());
}
}
