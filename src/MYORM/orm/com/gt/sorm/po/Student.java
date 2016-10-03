package MYORM.orm.com.gt.sorm.po;

import java.util.*;
import java.sql.*;

public class Student{

	private String sname;

	private Integer sid;

	private Integer cid;

	public void setSname(String sname){
		this.sname = sname;
	}
	public String getSname(){
		return sname;
	}
	public void setSid(Integer sid){
		this.sid = sid;
	}
	public Integer getSid(){
		return sid;
	}
	public void setCid(Integer cid){
		this.cid = cid;
	}
	public Integer getCid(){
		return cid;
	}
}
