package MYORM.orm.com.gt.sorm.bean;

/**
 * 
 * 描述：配置信息
 * 
 * @author gt
 * @created 2016年8月31日 下午11:17:11
 * @since
 */
public class Configuration {
	/**
	 * 驱动类
	 */
	private String driver;
	/**
	 * jdbcURL
	 */
	private String url;
	/**
	 * 用户名
	 */
	private String user;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 所用数据库
	 */
	private String usingDB;
	/**
	 * java持久化类的地址
	 */
	private String srcPath;
	/**
	 * java持久化包的路径
	 */
	private String packagePath;

	public Configuration() {
	}

	public Configuration(String driver, String url, String user,
			String password, String usingDB, String srcPath, String packagePath) {
		super();
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
		this.usingDB = usingDB;
		this.srcPath = srcPath;
		this.packagePath = packagePath;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsingDB() {
		return usingDB;
	}

	public void setUsingDB(String usingDB) {
		this.usingDB = usingDB;
	}

	public String getSrcPath() {
		return srcPath;
	}

	public void setSrcPath(String srcPath) {
		this.srcPath = srcPath;
	}

	public String getPackagePath() {
		return packagePath;
	}

	public void setPackagePath(String packagePath) {
		this.packagePath = packagePath;
	}

}
