package Annotation.demo2;

@Table("tb_shopping")
public class Shoping {
	@Column(columnName = "t_id", type = "varchar", length = "10")
	private String id;
	@Column(columnName = "t_name", type = "varchar", length = "10")
	private String name;
	@Column(columnName = "t_price", type = "float", length = "10")
	private double price;
	@Column(columnName = "t_desc", type = "varchar", length = "10")
	private String desc;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
