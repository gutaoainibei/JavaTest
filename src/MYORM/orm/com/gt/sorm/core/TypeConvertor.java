package MYORM.orm.com.gt.sorm.core;

public interface TypeConvertor {
	/**
	 * 
	 * 描述：把java数据类型转化为数据库数据类型
	 * @author gt
	 * @created 2016年8月30日 下午10:49:43
	 * @since 
	 * @return
	 */
	public String javaDataTypetoDatabaseType(String javaType);
	/**
	 * 
	 * 描述：将数据库数据类型转化为java数据类型
	 * @author gt
	 * @created 2016年8月30日 下午10:54:28
	 * @since 
	 * @param columnType
	 * @return
	 */
	public String DatabaseTypetojavaDataType(String columnType);
}
