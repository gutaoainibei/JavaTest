package MYORM.orm.com.gt.sorm.po;

import java.util.*;
import java.sql.*;

public class Class{

	private String cname;

	private Integer tid;

	private Integer cid;

	public void setCname(String cname){
		this.cname = cname;
	}
	public String getCname(){
		return cname;
	}
	public void setTid(Integer tid){
		this.tid = tid;
	}
	public Integer getTid(){
		return tid;
	}
	public void setCid(Integer cid){
		this.cid = cid;
	}
	public Integer getCid(){
		return cid;
	}
}
