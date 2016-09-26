package MYORM.orm.com.gt.sorm.utils;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import sun.util.logging.resources.logging;
import MYORM.orm.com.gt.sorm.bean.ColumnInfo;
import MYORM.orm.com.gt.sorm.bean.JavaFieldGetSet;
import MYORM.orm.com.gt.sorm.bean.TableInfo;
import MYORM.orm.com.gt.sorm.core.DBManager;
import MYORM.orm.com.gt.sorm.core.MysqlTypeConvertor;
import MYORM.orm.com.gt.sorm.core.TableContext;
import MYORM.orm.com.gt.sorm.core.TypeConvertor;

/**
 * 
 * 描述：封装了生成java文件(源代码)常用的操作
 * @author gt
 * @created 2016年8月30日 下午10:56:12
 * @since
 */
public class JavaFileUtils {
	private static Logger logger = Logger.getLogger(JavaFileUtils.class);
   /**
    * 
    * 描述：根据列信息生成对应的java属性和set、get方法的内容的字符串
    * @author gt
    * @created 2016年9月26日 下午3:08:30
    * @since 
    * @param columnInfo 列信息
    * @param convertor 转换器
    * @return
    */
	public static JavaFieldGetSet createFieldSetGetSRC(ColumnInfo columnInfo,TypeConvertor convertor){
		JavaFieldGetSet jfgs = new JavaFieldGetSet();
		String javaFieldType = convertor.DatabaseTypetojavaDataType(columnInfo.getDataType());
		//1.属性定义语句生成
		jfgs.setFieldInfo("\tprivate "+javaFieldType+" "+columnInfo.getName()+";\n");
		StringBuffer setInfo = new StringBuffer();
		setInfo.append("\tpublic void set"+StringUtils.upFirstCharOfString(columnInfo.getName())+"(");
		setInfo.append(javaFieldType+" "+columnInfo.getName()+"){\n");
		setInfo.append("\t\tthis."+columnInfo.getName()+" = "+columnInfo.getName()+";\n");
		setInfo.append("\t}\n");
		//2.set方法定义语句生成
		jfgs.setGetInfo(setInfo.toString());
		StringBuffer getInfo = new StringBuffer();
		getInfo.append("\tpublic "+javaFieldType+" get"+StringUtils.upFirstCharOfString(columnInfo.getName())+"(){\n");
		getInfo.append("\t\treturn "+columnInfo.getName()+";\n");
		getInfo.append("\t}\n");
		//3.get方法定义语句生成
		jfgs.setSetInfo(getInfo.toString());
		return jfgs;
	}
	/**
	 * 
	 * 描述：把表对应的java类的bean的内容拼接出来
	 * @author gt
	 * @created 2016年9月26日 下午3:06:54
	 * @since 
	 * @param tableInfo 表信息
	 * @param convertor 转换器
	 * @return
	 */
	public static String createJavaSrcStr(TableInfo tableInfo,TypeConvertor convertor){
		Map<String, ColumnInfo> map = tableInfo.getColumns();
		List<JavaFieldGetSet> list = new ArrayList<JavaFieldGetSet>();
		for (ColumnInfo columnInfo : map.values()) {
			list.add(createFieldSetGetSRC(columnInfo,convertor));
		}
		StringBuffer classStr = new StringBuffer();
		classStr.append("package "+DBManager.getConfig().getPackagePath()+";\n\n");
		classStr.append("import java.util.*;\n");
		classStr.append("import java.sql.*;\n\n");
		classStr.append("public class "+StringUtils.upFirstCharOfString(tableInfo.getTname())+"{\n\n");
		//拼接类属性
		for (JavaFieldGetSet javaFieldGetSet : list) {
			classStr.append(javaFieldGetSet.getFieldInfo()+"\n");
		}
		//拼接set、get方法
		for (JavaFieldGetSet javaFieldGetSet : list) {
			classStr.append(javaFieldGetSet.getGetInfo());
			classStr.append(javaFieldGetSet.getSetInfo());
		}
		classStr.append("}\n");
		return classStr.toString();
	}
	/**
	 * 
	 * 描述：创建java文件
	 * @author gt
	 * @created 2016年9月26日 下午3:52:47
	 * @since 
	 * @param tableInfo 表信息
	 * @param convertor 转换器
	 */
	public static void creteJavaFile(TableInfo tableInfo,TypeConvertor convertor){
		String srcStr = createJavaSrcStr(tableInfo, convertor);
		String srcPath = DBManager.getConfig().getSrcPath();
		String packagePath = DBManager.getConfig().getPackagePath().replaceAll("\\.", "/");
	    BufferedWriter writer = null;
	    String fllePath = srcPath+"/"+packagePath+"/";
	    File file = new File(fllePath);
	    if(!file.exists()){//如果目录不存在就创建
	    	file.mkdirs();
	    }
	    try {
			writer = new BufferedWriter(new FileWriter(file.getAbsolutePath()+"/"+StringUtils.upFirstCharOfString(tableInfo.getTname())+".java"));
			logger.info("创建文件："+file.getAbsolutePath()+"/"+StringUtils.upFirstCharOfString(tableInfo.getTname())+".java");
			writer.write(srcStr);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
//		ColumnInfo columnInfo = new ColumnInfo("username","int",0);
//		JavaFieldGetSet f = createFieldSetGetSRC(columnInfo, new MysqlTypeConvertor());
//		System.out.println(f);
		Map<String,TableInfo> tableInfos = TableContext.tables;
		for (TableInfo tableInfo : tableInfos.values()) {
			creteJavaFile(tableInfo, new MysqlTypeConvertor());
		}
	}
}
