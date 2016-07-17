package designPattern.Proxy.staticProxy;
/**
 * 
 * 描述：名星接口
 * @author gt
 * @created 2016年7月17日 下午11:41:00
 * @since
 */
public interface Star {
	/**
	 * 
	 * 描述：面谈
	 * @author gt
	 * @created 2016年7月17日 下午11:44:47
	 * @since
	 */
    public void confer();
    /**
     * 
     * 描述：签约
     * @author gt
     * @created 2016年7月17日 下午11:44:58
     * @since
     */
    public void signContract();
    /**
     * 
     * 描述：订票
     * @author gt
     * @created 2016年7月17日 下午11:45:12
     * @since
     */
    public void bookTicket();
    /**
     * 
     * 描述：唱歌
     * @author gt
     * @created 2016年7月17日 下午11:45:23
     * @since
     */
    public void sing();
    /**
     * 
     * 描述：收钱
     * @author gt
     * @created 2016年7月17日 下午11:45:45
     * @since
     */
    public void collectMoney();
}
