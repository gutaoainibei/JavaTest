package MYORM.orm.com.gt.sorm.po;

import java.util.*;
import java.sql.*;

public class Address{

	private Integer id;

	private String update_time;

	private String address;

	private String create_time;

	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
	}
	public void setUpdate_time(String update_time){
		this.update_time = update_time;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public String getAddress(){
		return address;
	}
	public void setCreate_time(String create_time){
		this.create_time = create_time;
	}
	public String getCreate_time(){
		return create_time;
	}
}
