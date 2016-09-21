package MYORM.orm.com.gt.sorm.bean;
/**
 * 
* @ClassName: JavaFieldGetSet 
* @Description: TODO(封装了java属性get、set方法的源代码) 
* @author gutao 
* @date 2016年9月20日 下午11:29:40 
*
 */
public class JavaFieldGetSet {
	/**
	 * 属性的源码信息，如：private int userId;
	 */
     private String fieldInfo;
     /**
      * get方法的源代码信息，如：public int getUserId(){}
      */
     private String getInfo;
     /**
      * set方法的源码信息，如：public void setUserId(int id){this.id = id;}
      */
     private String setInfo;
	public String getFieldInfo() {
		return fieldInfo;
	}
	public void setFieldInfo(String fieldInfo) {
		this.fieldInfo = fieldInfo;
	}
	public String getGetInfo() {
		return getInfo;
	}
	public void setGetInfo(String getInfo) {
		this.getInfo = getInfo;
	}
	public String getSetInfo() {
		return setInfo;
	}
	public void setSetInfo(String setInfo) {
		this.setInfo = setInfo;
	}
	public JavaFieldGetSet(String fieldInfo, String getInfo, String setInfo) {
		super();
		this.fieldInfo = fieldInfo;
		this.getInfo = getInfo;
		this.setInfo = setInfo;
	}
	public JavaFieldGetSet() {
	}
     
}
