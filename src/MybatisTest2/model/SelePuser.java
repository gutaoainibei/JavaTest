package MybatisTest2.model;

public class SelePuser {
	private String name;
	private int minage;
	private int maxage;

	
	public SelePuser(String name, int minage, int maxage) {
		super();
		this.name = name;
		this.minage = minage;
		this.maxage = maxage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMinage() {
		return minage;
	}

	public void setMinage(int minage) {
		this.minage = minage;
	}

	public int getMaxage() {
		return maxage;
	}

	public void setMaxage(int maxage) {
		this.maxage = maxage;
	}

}
