package TestIO.systemIO;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import TestIO.FileUtils;

/**
 * 
 * 描述：打印流，处理流
 * @author gt
 * @created 2016年4月2日 下午11:55:59
 * @since
 */
public class TestSystemOut {
    public static void main(String[] args) throws FileNotFoundException {
		System.out.println("test");
		PrintStream ps = System.out;
		ps.println(false);
		
		File file = new File("F:/JavaIO/systemio.txt");
		//ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(file)));
		ps = new PrintStream(file);//这里打印流是输出流，这里指定要写出到file文件中
		ps.println("gutao ai ni");
		ps.flush();
		ps.close();
	}
}
