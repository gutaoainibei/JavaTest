package MYORM.orm.com.gt.sorm.po;

import java.util.*;
import java.sql.*;

public class User{

	private String name;

	private Integer id;

	private Integer age;

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
	public void setAge(Integer age){
		this.age = age;
	}
	public Integer getAge(){
		return age;
	}
}
