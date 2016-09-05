package designPattern.build;
/**
 * 
 * 描述：飞船组装模型实现
 * @author gt
 * @created 2016年7月10日 下午11:44:00
 * @since
 */
public class AirShipDirectorImpl implements AirShipDirector{
    
	private AirShipBuild airShipBuild;
	public AirShipDirectorImpl(AirShipBuild airShipBuild){
		this.airShipBuild = airShipBuild;
	}
	public AirShipModle createAirShipModle() {
		AirShipModle airShipModle = new AirShipModle();
		airShipModle.setEngine(this.airShipBuild.engineBuilder());
		airShipModle.setTrackBin(this.airShipBuild.trackBinBuilder());
        airShipModle.setEscapeTower(this.airShipBuild.escapeTowerBuilder());
	    return airShipModle;
	}

}
