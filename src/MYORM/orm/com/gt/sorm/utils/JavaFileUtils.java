package MYORM.orm.com.gt.sorm.utils;

import MYORM.orm.com.gt.sorm.bean.ColumnInfo;
import MYORM.orm.com.gt.sorm.bean.JavaFieldGetSet;
import MYORM.orm.com.gt.sorm.core.MysqlTypeConvertor;
import MYORM.orm.com.gt.sorm.core.TypeConvertor;

/**
 * 
 * 描述：封装了生成java文件(源代码)常用的操作
 * @author gt
 * @created 2016年8月30日 下午10:56:12
 * @since
 */
public class JavaFileUtils {
   
	public static JavaFieldGetSet createFieldSetGetSRC(ColumnInfo columnInfo,TypeConvertor convertor){
		JavaFieldGetSet jfgs = new JavaFieldGetSet();
		String javaFieldType = convertor.DatabaseTypetojavaDataType(columnInfo.getDataType());
		jfgs.setFieldInfo("\tprivate "+javaFieldType+" "+columnInfo.getName()+";\n");
		StringBuffer setInfo = new StringBuffer();
		setInfo.append("\tpublic "+javaFieldType+" set"+StringUtils.upFirstCharOfString(columnInfo.getName())+"(");
		setInfo.append(javaFieldType+" "+columnInfo.getName()+"){\n");
		setInfo.append("\t\tthis."+columnInfo.getName()+" = "+columnInfo.getName()+";\n");
		setInfo.append("\t}\n");
		jfgs.setGetInfo(setInfo.toString());
		StringBuffer getInfo = new StringBuffer();
		getInfo.append("\tpublic "+javaFieldType+" get"+StringUtils.upFirstCharOfString(columnInfo.getName())+"(){\n");
		getInfo.append("\t\treturn "+columnInfo.getName()+";\n");
		getInfo.append("\t}\n");
		jfgs.setSetInfo(getInfo.toString());
		return jfgs;
	}
	public static void main(String[] args) {
		ColumnInfo columnInfo = new ColumnInfo("username","int",0);
		JavaFieldGetSet f = createFieldSetGetSRC(columnInfo, new MysqlTypeConvertor());
		System.out.println(f);
	}
}
