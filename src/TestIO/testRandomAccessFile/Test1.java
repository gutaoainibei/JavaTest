package TestIO.testRandomAccessFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import TestIO.FileUtils;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 
 * 描述：测试RandomAccessFile类
 * @author gt
 * @created 2016年4月6日 下午11:38:30
 * @since
 */
public class Test1 {
    public static void main(String[] args) throws IOException {
		RandomAccessFile randomAccessFile = new RandomAccessFile(new File("F:/JavaIO/gutao.txt"), "r");
	    randomAccessFile.seek(10);//设置锚点，从哪里开始读取，用这个可以实现文件的分割和合并
	    byte[] flush = new byte[1024];
	    System.out.println("gutao");
	    int len = 0;
	    while (-1!=(len = randomAccessFile.read(flush))) {
	    	System.out.println("=====");
			System.out.println(new String(flush, 0, len));
		}
	    FileUtils.Close(randomAccessFile);
    }
}
