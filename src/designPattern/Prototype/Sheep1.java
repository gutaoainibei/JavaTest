package designPattern.Prototype;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 描述：深度克隆
 * 
 * @author gt
 * @created 2016年7月11日 下午11:46:01
 * @since
 */
public class Sheep1 implements Cloneable,Serializable{

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

	public Sheep1(String name, Date birthday) {
		super();
		this.name = name;
		this.birthday = birthday;
	}
   public Sheep1(){}
   @Override
   protected Object clone() throws CloneNotSupportedException {
	     Object object = super.clone();
	     //深度代码复制
	     Sheep1 s = (Sheep1) object;
	     s.birthday = (Date)this.birthday.clone();
	     return object;
   }
}
