package TestIO;

import java.io.File;
import java.io.IOException;
/**
 * 
 * 描述：常用方法：
 *      1.文件名
 *      getName()文件名，路径名
 *      getPath()路径名
 *      getAbsoluteFile()绝对路径所对应的File对象
 *      getAbsolutePath()绝对路径名
 *      getParent()父目录，相对路径的父目录，可能为null如：删除本身后的结果
 *      2.判断信息
 *      exists()
 *      canWrite()
 *      canRead()
 *      isFile()
 *      isDirectory
 *      isAbsolute()消除平台差异，windows以盘符开头，其他以/开头
 *      length()如果是文件夹长度为0，长度为文件的字节数
 *      创建和删除
 *      createNewFile()创建新文件
 *      delete()删除文件，要删除文件夹的时候必须先删除里面的所有文件
 *      
 * @author gt
 * @created 2016年3月24日 下午4:41:04
 * @since
 */
public class TestFileBaseMethod {
   public static void main(String[] args) {
	   String path = "F:/JavaIO/nibei";
	   File file = new File(path);
	   //删除文件夹之前一定要先删除文件夹里面的文件
	   file.delete();
   }
   /**
    * 描述：创建文件
    * @author gt
    * @created 2016年3月25日 上午10:55:54
    * @since
    */
   public static void testCreateFile(){
	   System.out.println("==========创建新文件===========");
	   String path = "F:/JavaIO/gutao/gt.txt";
	   File file = new File(path);
	   if(!file.exists()){
		   try {
			boolean fieltrue = file.createNewFile();
			System.out.println("创建"+(fieltrue ? "成功":"失败"));
		} catch (IOException e) {
			System.out.println("文件创建异常");
			e.printStackTrace();
		}
	   }
		   //删除文件
		   boolean deletrue = file.delete();
		   System.out.println("删除"+(deletrue ? "成功":"失败"));
	   //创建临时文件
	   try {
			File fileTemp = File.createTempFile("gttempfile", ".temp",new File("F:/JavaIO/gutao"));
			Thread.sleep(10000);
			fileTemp.deleteOnExit();
			System.out.println("结束");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
   }
   
   /**
    * 描述：File类的基本应用
    * @author gt
    * @created 2016年3月25日 上午10:40:47
    * @since
    */
   public static void testFileBaseMethod(){
	      //String path = "F:/JavaIO/gutao1";
		  //String path = "F:/JavaIO/gutao";
		  String path = "F:/JavaIO/gutao/nibei.txt";
		  File file = new File(path);
		  //是否存在
		  System.out.println("文件是否存在："+file.exists());
		  //是否可以读写
		  System.out.println("文件是否可读："+file.canRead());
		  System.out.println("文件是否可写："+file.canWrite());
		  if(file.isFile()){
			  System.out.println("文件");
		  }else if(file.isDirectory()){
			  System.out.println("文件夹");
		  }else{
			  System.out.println("文件不存在");
		  }
		  System.out.println("是否是文件的绝对路径："+file.isAbsolute());
		  System.out.println("文件的长度:"+file.length());      
   }
   /**
    * 描述：获取文件路径
    * @author gt
    * @created 2016年3月25日 上午10:41:13
    * @since
    */
   public static void testFilePathAndName(){
	    //这个类就是为了建立联系
	    File file = new File("gt.txt");
	    System.out.println(file.getName());//返回文件名
	    System.out.println(file.getPath());//如果是绝对路径，返回完整路径，如果是相对路径，则返回相对路径
	    System.out.println(file.getParent());//返回上一级目录，如果是相对的，返回null
	    System.out.println(file.getAbsolutePath());//返回绝对路径
   }
}
