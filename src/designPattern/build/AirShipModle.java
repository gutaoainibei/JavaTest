package designPattern.build;

/**
 * 
 * 描述：飞船模型
 * 
 * @author gt
 * @created 2016年7月10日 下午11:18:38
 * @since
 */
public class AirShipModle {
	private Engine engine;
	private EscapeTower escapeTower;
	private TrackBin trackBin;

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public EscapeTower getEscapeTower() {
		return escapeTower;
	}

	public void setEscapeTower(EscapeTower escapeTower) {
		this.escapeTower = escapeTower;
	}

	public TrackBin getTrackBin() {
		return trackBin;
	}

	public void setTrackBin(TrackBin trackBin) {
		this.trackBin = trackBin;
	}

}

/**
 * 
 * 描述：发动机
 * 
 * @author gt
 * @created 2016年7月10日 下午11:25:07
 * @since
 */
class Engine {
	private String name;
    
	public Engine(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

/**
 * 
 * 描述：逃身塔
 * 
 * @author gt
 * @created 2016年7月10日 下午11:24:38
 * @since
 */
class EscapeTower {
	private String name;
  
	public EscapeTower(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

/**
 * 
 * 描述：轨道仓
 * 
 * @author gt
 * @created 2016年7月10日 下午11:21:40
 * @since
 */
class TrackBin {
	private String name;

	public TrackBin(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}