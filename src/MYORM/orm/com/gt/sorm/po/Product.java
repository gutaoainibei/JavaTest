package MYORM.orm.com.gt.sorm.po;

import java.util.*;
import java.sql.*;

public class Product{

	private String address;

	private Integer counts;

	private String name;

	private Integer id;

	public void setAddress(String address){
		this.address = address;
	}
	public String getAddress(){
		return address;
	}
	public void setCounts(Integer counts){
		this.counts = counts;
	}
	public Integer getCounts(){
		return counts;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
	}
}
