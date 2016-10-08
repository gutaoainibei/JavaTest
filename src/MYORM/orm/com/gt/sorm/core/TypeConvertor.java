package MYORM.orm.com.gt.sorm.core;

public interface TypeConvertor {
	/**
		* @Title: javaDataTypetoDatabaseType 
		* @Description: 把java数据类型转化为数据库数据类型 
		* @param @param 需要转换的java类型
		* @param @return    设定文件 
		* @return String    返回类型 
		* @throws
	 */
	public String javaDataTypetoDatabaseType(String javaType);
	/**
		* @Title: DatabaseTypetojavaDataType 
		* @Description: 将数据库数据类型转化为java数据类型 
		* @param @param 需要转换的数据类型
		* @param @return    设定文件 
		* @return String    返回类型 
		* @throws
	 */
	public String DatabaseTypetojavaDataType(String columnType);
}
