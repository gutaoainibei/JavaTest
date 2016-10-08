package MYORM.orm.com.gt.sorm.core;
/**
 * 
* @ClassName: MysqlTypeConvertor 
* @Description:mysql数据库类型转换类 
* @author gutao 
* @date 2016年10月8日 下午1:13:26 
*
 */
public class MysqlTypeConvertor implements TypeConvertor {

	@Override
	public String javaDataTypetoDatabaseType(String javaType) {
		
		return null;
	}

	@Override
	public String DatabaseTypetojavaDataType(String columnType) {
		if("varchar".equalsIgnoreCase(columnType)||"char".equalsIgnoreCase(columnType)){
			 return "String";
		}else if ("int".equalsIgnoreCase(columnType)||
				  "tinyint".equalsIgnoreCase(columnType)||
				  "integer".equalsIgnoreCase(columnType)||
				  "smallint".equalsIgnoreCase(columnType)){
			return "Integer";
		}else if ("bigint".equalsIgnoreCase(columnType)) {
			return "Long";
		}else if ("double".equalsIgnoreCase(columnType)||"float".equalsIgnoreCase(columnType)) {
			return "Double";
		}else if ("clob".equalsIgnoreCase(columnType)) {
			return "java.sql.Clob";
		}else if ("blob".equalsIgnoreCase(columnType)) {
			return "java.sql.Blob";
		}else if ("date".equalsIgnoreCase(columnType)) {
			return "java.sql.Date";
		}else if ("time".equalsIgnoreCase(columnType)) {
			return "java.sql.Time";
		}else if ("timestamp".equalsIgnoreCase(columnType)) {
			return "java.sql.Timestamp";
		}
		return null;
	}

}
