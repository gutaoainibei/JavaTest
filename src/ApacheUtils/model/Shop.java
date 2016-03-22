package ApacheUtils.model;

/**
 * 
 * 描述：商品模型类
 * 
 * @author gt
 * @created 2016年3月22日 下午6:59:41
 * @since
 */
public class Shop {
	private String name;
	private Double price;
	private boolean discount;

	public Shop(String name, Double price, boolean discount) {
		super();
		this.name = name;
		this.price = price;
		this.discount = discount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public boolean isDiscount() {
		return discount;
	}

	public void setDiscount(boolean discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Shop [商品名称=" + name + ", 商品价格=" + price + ", 是否打折="
				+(discount?"是":"否")+ "]";
	}
   
}
