package TestIO.copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;

import TestIO.FileUtils;

/**
 * 
 * 描述：测试文件的拷贝
 *      一、读取文件
 *         1.建立联系 File对象 源头 new File(strpath) or new File(parentFile,strname),
 *                         目的 new FIle(strDestpath) or new File(parentFile,strDestname); 
 *         2.选择流 文件输入流 InputStream FileInputStream
 *         3.操作：byte[] car = new byte[1024];每次读入量设置 +read(byte[] b) 读入
 *         4. 释放资源：关闭 close()
 *         
 *      二、文件的写入
 *         1.建立联系： File对象 目的地 new File(strpath) or new File(parentFile,strname),
 *         2.选择流：文件输出流 OutputSream FileOutputStream
 *         3.操作：write(byte[] b,int off,int len)+flush()
 *         4.释放资源：关闭 close()
 *      三、文件的拷贝 程序作为桥梁
 *          1.建立联系 File对象 源头 目的地
 *          2.选择流： 文件输入流 InputStream FileInputStream
 *                  文件输出流 OutputSream FileOutputStream
 *          3.操作：int len = 0;
 *                 byte[] b = new byte[1024];
 *                 while((len=in.read(b))!=-1){
 *                    out.write(b,0,len);
 *                 } 
 *                 out.flush();
 *          4.释放资源：关闭 close();       
 * @author gt
 * @created 2016年3月28日 上午10:10:36
 * @since
 */
public class CopyFile {
	static Logger logger = Logger.getLogger(CopyFile.class);
    public static void main(String[] args) throws IOException {
    	
	    String srcpath = "F:/JavaIO/1.jpg";	
	    String destpath = "F:/JavaIO/lm/4.jpg";
//	    String srcFolder = "F:/JavaIO/gutao";
//	    String destFolder = "F:/JavaIO/li";
//	    File filesrc = new File(srcFolder);
//	    File filedest = new File(destFolder);
//		FileUtils.CopyFolder(filesrc, filedest);
        FileUtils.CopyFile(srcpath, destpath);
	
	}
}
