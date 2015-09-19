package MybatisTest2.model;

public class Puser {
	private int pid;
	private String pname;
	private int age;
	private int sex;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Puser [pid=" + pid + ", pname=" + pname + ", age=" + age + ", sex=" + sex + "]";
	}

    
	

}
