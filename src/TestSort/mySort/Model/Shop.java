package TestSort.mySort.Model;

/**
 * 
 * 描述：商品模型类
 * 
 * @author gt
 * @created 2016年3月8日 下午3:47:40
 * @since
 */
public class Shop {
	private String address;
	private String name;
	private int soles_Volume;
    
	public Shop() {
		super();
	}

	public Shop(String address, String name, int soles_Volume) {
		this.address = address;
		this.name = name;
		this.soles_Volume = soles_Volume;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSoles_Volume() {
		return soles_Volume;
	}

	public void setSoles_Volume(int soles_Volume) {
		this.soles_Volume = soles_Volume;
	}

	@Override
	public String toString() {
		return "Shop [address=" + address + ", name=" + name
				+ ", soles_Volume=" + soles_Volume + "]";
	}
}
