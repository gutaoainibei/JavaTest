package TestIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;
/**
 * 描述：文件操作：拷贝
 * @author gt
 * @created 2016年3月28日 上午11:01:11
 * @since
 */
public class FileUtils {
	static Logger logger = Logger.getLogger(FileUtils.class);
	/**
	 * 描述：按路径拷贝文件
	 * @author gt
	 * @created 2016年3月28日 上午11:04:06
	 * @since 
	 * @param srcPath:原文件路径
	 * @param destPath:目的路径
	 * @throws IOException 
	 */
    public static void CopyFile(String srcPath,String destPath) throws IOException{
    	//关联写入流
	    File srcFile = new File(srcPath);
	    //关联写出流
	    File desFile = new File(destPath);
	    CopyFile(srcFile, desFile);
    }
    /**
     * 描述：拷贝文件
     * @author gt
     * @created 2016年3月28日 上午11:07:17
     * @since 
     * @param srcFile:原拷贝文件
     * @param destFile:目的拷贝文件(这里可以是文件夹，如果是文件夹，就把文件考到该目录下)
     * @throws IOException 
     */
    public static void CopyFile(File srcFile , File destFile) throws IOException,FileNotFoundException{
    	if(!srcFile.isFile()){
    		throw new IOException("源文件不能是文件夹");
    	}
    	if (destFile.isDirectory()) {
			destFile = new File(destFile,srcFile.getName());
		}
    	//读入流
	    InputStream in = null;
	    //写出流
	    OutputStream out = null;
		//建立读取联系
		in = new BufferedInputStream(new FileInputStream(srcFile));
		out = new BufferedOutputStream(new FileOutputStream(destFile));
	    //读取长度
	    int len = 0;
	    //每次读入的字节数
	    byte[] b = new byte[1024];
		while ((len=in.read(b)) != -1) {
				out.write(b, 0, len);
		}
		out.flush();
		FileUtils.Close(in,out);
    }
    /**
     * 描述：按路径拷贝文件夹
     * @author gt
     * @created 2016年3月28日 下午1:54:21
     * @since 
     * @param srcPath:源文件夹的路径（就是你要要拷贝的文件夹的路径）
     * @param destPath:目的文件夹的路径（就是你要拷贝到的目录下）
     * @throws IOException
     */
    public static void CopyFolder(String srcPath , String destPath) throws IOException{
    	File srcFolder= new File(srcPath);
    	File destFolder = new File(destPath);
        if(srcFolder.isFile()){
        	throw new IOException("文件夹拷贝，源文件不能是文件");
        } 
        if (destFolder.isFile()) {
        	throw new IOException("文件夹拷贝，目的文件不能是文件");
		}
        CopyFolder(srcFolder, destFolder);
    }
    /**
     * 描述：拷贝文件夹
     * @author gt
     * @created 2016年3月28日 下午1:52:08
     * @since 
     * @param srcFolder:源文件夹（简单来说就是要拷贝的文件夹）
     * @param destFolder:目的文件夹（简单的来说就是要拷贝到的目录）
     * @throws IOException
     */
    public static void CopyFolder(File srcFolder,File destFolder) throws IOException{
    	if(destFolder.getAbsolutePath().contains(srcFolder.getAbsolutePath())){
    		System.out.println("父文件夹不能拷到子文件夹下");
    		return;
    	}
    	if(srcFolder.isFile()){
        	throw new IOException("文件夹拷贝，源文件不能是文件");
        } 
        if (destFolder.isFile()) {
        	throw new IOException("文件夹拷贝，目的文件不能是文件");
		}
        //将目的文件
    	destFolder = new File(destFolder,srcFolder.getName());
    	//在你要考到的目录下，先建立你要拷贝的文件夹
    	destFolder.mkdirs();
    	//遍历你要拷贝的文件夹下的子文件
        for (File child_file : srcFolder.listFiles()) {
        	
			//如果是文件夹，则继续遍历
        	if(!child_file.isFile()){
				CopyFolder(child_file, destFolder);
			}else if (child_file.isDirectory()) {
				//拷贝文件
				CopyFile(child_file, new File(destFolder, child_file.getName()));
			}
		}
    }
    /**
     * 
     * 描述：关闭工具方法
     *      可变参数：... 只能是形参最后一个参数,处理方式和数组一致
     *      
     *      The variable argument type Closeable of 
     *      the method CloseAll must be the last parameter
     * @author gt
     * @created 2016年4月1日 上午12:10:55
     * @since 
     * @param io
     */
    public static void Close(Closeable ... io){
    	for (Closeable closeable : io) {
			try {
				if(null != closeable){
				 closeable.close();
				}
				} catch (Exception e) {
			}
		}
    }
    /**
     * 
     * 描述：使用泛型方法来实现关闭
     * @author gt
     * @created 2016年4月1日 上午12:40:59
     * @since 
     * @param io
     */
    public static <T extends Closeable> void CloseAll(T ... io){
    	for (Closeable t : io) {
			try {
				if(null != t){
				t.close();
				}
			} catch (Exception e) {
			}
		}
    }
}
