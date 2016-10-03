package MYORM.orm.com.gt.sorm.po;

import java.util.*;
import java.sql.*;

public class Teacher{

	private String tname;

	private Integer tid;

	public void setTname(String tname){
		this.tname = tname;
	}
	public String getTname(){
		return tname;
	}
	public void setTid(Integer tid){
		this.tid = tid;
	}
	public Integer getTid(){
		return tid;
	}
}
