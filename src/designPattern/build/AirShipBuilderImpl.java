package designPattern.build;

public class AirShipBuilderImpl implements AirShipBuild{

	@Override
	public Engine engineBuilder() {
		System.out.println("发动机构造");
		return new Engine("顾涛");
	}

	@Override
	public TrackBin trackBinBuilder() {
		System.out.println("轨道舱构造");
		return new TrackBin("顾涛轨道");
	}

	@Override
	public EscapeTower escapeTowerBuilder() {
		System.out.println("逃身舱构造");
		return new EscapeTower("nb逃生舱");
	}

}
