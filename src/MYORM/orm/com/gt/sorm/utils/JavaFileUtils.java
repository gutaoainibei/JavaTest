package MYORM.orm.com.gt.sorm.utils;

import MYORM.orm.com.gt.sorm.bean.ColumnInfo;
import MYORM.orm.com.gt.sorm.bean.JavaFieldGetSet;
import MYORM.orm.com.gt.sorm.core.TypeConvertor;

/**
 * 
 * 描述：封装了生成java文件(源代码)常用的操作
 * @author gt
 * @created 2016年8月30日 下午10:56:12
 * @since
 */
public class JavaFileUtils {
   
	public static void main(String[] args) {
		
	}
	public static JavaFieldGetSet createFieldSetGetSRC(ColumnInfo columnInfo,TypeConvertor convertor){
		String javaFieldType = convertor.DatabaseTypetojavaDataType(columnInfo.getDataType());
		return null;
	}
}
