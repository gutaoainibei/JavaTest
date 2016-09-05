package TestIO;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

/**
 * 
 * 描述：操作目录
 *      mkdir()创建目录，必须确保父目录存在，如果不存在，创建失败
 *      mkdirs()创建目录，如果父目录链不存在一同创建
 *      list()文件|目录字符串形式
 *      list()Files()
 *      
 * @author gt
 * @created 2016年3月25日 下午2:18:39
 * @since
 */
public class Testmkdir {
     public static void main(String[] args) {
     	String path = "F:/JavaIO";
        File file = new File(path);
        if(file.isDirectory()){
        	//列出子文件名
        	String[] childFileName = file.list();
        	System.out.println("===========列出子文件名===========");
        	for (String string : childFileName) {
				System.out.println(string);
				
			}
        	//列出子文件对象
        	File[] childFile = file.listFiles();
        	System.out.println("===========列出子文对象===========");
        	for (File childfile : childFile) {
        		//File重写了toString()方法
				System.out.println(childfile);
			}
        	System.out.println("===========过滤输出文件============");
        	childFile = file.listFiles(new FilenameFilter() {
        		//这里的dir就是file，name就是子文件名,""
				public boolean accept(File dir, String name) {
					return new File(dir, name).isFile() && name.endsWith(".txt");
				}
			});
        	for (File acceptfile : childFile) {
				System.out.println(acceptfile);
			}
        	System.out.println("==========用断言来实现过滤==============");
        	//这里我用断言来实现一个与上面一样可以过滤掉不满足条件的
        	childFile = file.listFiles();
        	Predicate<File> predicate = new Predicate<File>() {
        		public boolean apply(File file) {
        			return file.isFile() && file.getName().endsWith(".txt");
        		}
        	};
        	Collection<File> listFiles = Collections2.filter(Arrays.asList(childFile), predicate); 
            for (File file2 : listFiles) {
				System.out.println(file2);
			}
        }
     }
     public static void TestMkdirAndMkdirs(){
    	String path = "F:/JavaIO/ming/gt/nb";
 		File file = new File(path);
 		//如果有上级有不存在的目录就无法创建
 		//file.mkdir();
 		//直接可以创建如果上级不存在就新建
 		file.mkdirs();
     }
}
