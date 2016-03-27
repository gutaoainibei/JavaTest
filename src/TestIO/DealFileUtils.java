package TestIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.google.common.base.Strings;

/**
 * 
 * 描述：列出文件的所有子孙级目录
 *      递归
 * @author gt
 * @created 2016年3月25日 下午5:09:49
 * @since
 */
public class DealFileUtils {
	 static List<String> names = new ArrayList<String>();
     public static void main(String[] args) {
		//SetProperties();
		listAllFile();
		//列出所有被删除的文件
		for (String string : names) {
			System.out.println(string);
		}
	}
     /**
      * 
      * 描述：列出所有子孙级目录
      * @author gt
      * @created 2016年3月25日 下午5:11:40
      * @since
      */
     public static void listAllFile(){
    	 Properties properties = new Properties();
    	 Properties properties2 = new Properties();
    	 try {
    		 //加载配置文件，这里写了两种方式，加载后缀不一样的配置文件
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("TestIO/Dir.properties"));
		    properties2.loadFromXML(Thread.currentThread().getContextClassLoader().getResourceAsStream("TestIO/Dir.xml"));
    	    //System.out.println("properties:"+"author:"+properties.get("author")+","+"dir:"+properties.get("dir"));
    	    //System.out.println("xml:"+"author:"+properties2.getProperty("author")+","+"dir:"+properties2.getProperty("dir"));
    	 } catch (IOException e) {
			e.printStackTrace();
		}
 	    String path = (String) properties.get("dir");
 	    System.out.println(path);
        File file = new File(path);
        getNeedFile(file);
     }
     /**
      * 
      * 描述：设置生成配置文件
      * @author gt
      * @created 2016年3月25日 下午7:06:20
      * @since
      */
     public static void SetProperties(){
    	 Properties properties = new Properties();
    	 properties.setProperty("author", "gutao");
    	 properties.setProperty("dir", "D:/mavenRepository");
    	 try {
			properties.store(new FileOutputStream(new File("D:/develop/workspace1/JavaTest/src/TestIO/Dir.properties")), "文件路径配置Properties文件");
		    properties.storeToXML(new FileOutputStream(new File("D:/develop/workspace1/JavaTest/src/TestIO/Dir.xml")), "文件路径配置XML文件");
    	 } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
     }
     /**
      * 
      * 描述：删除目录下所有的.lastUpdated文件
      * @author gt
      * @created 2016年3月25日 下午7:09:53
      * @since 
      * @param file
      */
    public static void getNeedFile(File file){
    	 File[] childFiles = file.listFiles();
    	 for (File childfile : childFiles) {
			if (childfile.isDirectory()) {
				getNeedFile(childfile);
			}else{
				if (childfile.getName().endsWith(".lastUpdated")) {
					names.add(childfile.getName());
					childfile.delete();
				}
			}
		}
    }
    
}
