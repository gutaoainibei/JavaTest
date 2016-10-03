package MYORM.orm.com.gt.sorm.po;

import java.util.*;
import java.sql.*;

public class Puser{

	private String pname;

	private Integer sex;

	private Integer pid;

	private Integer age;

	public void setPname(String pname){
		this.pname = pname;
	}
	public String getPname(){
		return pname;
	}
	public void setSex(Integer sex){
		this.sex = sex;
	}
	public Integer getSex(){
		return sex;
	}
	public void setPid(Integer pid){
		this.pid = pid;
	}
	public Integer getPid(){
		return pid;
	}
	public void setAge(Integer age){
		this.age = age;
	}
	public Integer getAge(){
		return age;
	}
}
