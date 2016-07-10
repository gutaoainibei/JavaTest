package designPattern.build;
/**
 * 
 * 描述：飞船模型建造接口
 * @author gt
 * @created 2016年7月10日 下午11:34:41
 * @since
 */
public interface AirShipBuild {
       Engine engineBuilder();
       TrackBin trackBinBuilder();
       EscapeTower escapeTowerBuilder();
}
