package designPattern.Prototype;

import java.util.Date;

/**
 * 
 * 描述：浅克隆
 * 
 * @author gt
 * @created 2016年7月11日 下午11:46:01
 * @since
 */
public class Sheep implements Cloneable {

	private String name;
	private Date birthday;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Sheep(String name, Date birthday) {
		super();
		this.name = name;
		this.birthday = birthday;
	}
   public Sheep(){}
   @Override
   protected Object clone() throws CloneNotSupportedException {
	     return super.clone();
   }
}
