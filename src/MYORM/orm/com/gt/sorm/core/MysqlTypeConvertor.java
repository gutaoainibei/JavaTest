package MYORM.orm.com.gt.sorm.core;

public class MysqlTypeConvertor implements TypeConvertor {

	@Override
	public String javaDataTypetoDatabaseType(String javaType) {
		if("varchar".equalsIgnoreCase(javaType)||"char".equalsIgnoreCase(javaType)){
			 return "String";
		}else if ("int".equalsIgnoreCase(javaType)||
				  "tinyint".equalsIgnoreCase(javaType)||
				  "integer".equalsIgnoreCase(javaType)||
				  "smallint".equalsIgnoreCase(javaType)){
			return "Integer";
		}else if ("bigint".equalsIgnoreCase(javaType)) {
			return "Long";
		}else if ("double".equalsIgnoreCase(javaType)||"float".equalsIgnoreCase(javaType)) {
			return "Double";
		}else if ("clob".equalsIgnoreCase(javaType)) {
			return "java.sql.Clob";
		}else if ("blob".equalsIgnoreCase(javaType)) {
			return "java.sql.Blob";
		}else if ("date".equalsIgnoreCase(javaType)) {
			return "java.sql.Date";
		}else if ("time".equalsIgnoreCase(javaType)) {
			return "java.sql.Time";
		}else if ("timestamp".equalsIgnoreCase(javaType)) {
			return "java.sql.Timestamp";
		}
		return null;
	}

	@Override
	public String DatabaseTypetojavaDataType(String columnType) {
		return null;
	}

}
