package TestIO.systemIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;


/**
 * 
 * 描述：打印流，处理流
 * @author gt
 * @created 2016年4月2日 下午11:55:59
 * @since
 */
public class TestSystemOut {
    public static void main(String[] args) throws IOException {
		//TestScanner();
    	//System();
    	//testSystemIn();
    	testSystemSetOut();
	}
    public static void testSystemIn() throws IOException{
    	InputStream in = System.in;
    	BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    	System.out.println("请输入");
    	System.out.println(reader.readLine());
    }
    public static void testSystemSetOut() throws FileNotFoundException{
    	System.setOut(new PrintStream(new FileOutputStream("F:/JavaIO/systemio.txt",true),true));
        System.out.println("ai");
        System.out.println("nibei");
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out),true));
        System.out.println("gutao ai nibei");
    }
    /**
     * 
     * 描述：测试标准流
     * @author gt
     * @created 2016年4月5日 下午11:42:21
     * @since
     */
    public static void System(){
    	System.out.println("gutao");
    	System.err.println("ai");//标准错误输出流
    	System.out.println("nibei");//标准输出流
    }
    /**
     * 
     * 描述：输入流测试
     * @author gt
     * @throws FileNotFoundException 
     * @created 2016年4月5日 下午11:32:14
     * @since
     */
    public static void TestScanner() throws FileNotFoundException{
    	Scanner scanner = new Scanner(System.in);
		System.out.print("请输入：");
		String string = scanner.nextLine();
		System.out.println(string);
		File file = new File("F:/JavaIO/systemio.txt");
		//Scanner可以通过file，inputstream，reader进行构造
		scanner = new Scanner(new InputStreamReader(new FileInputStream(file)));
        System.out.println(scanner.nextLine());
    }
    /**
     * 
     * 描述：测试输出流，System.out是标准输出流
     * @author gt
     * @throws FileNotFoundException 
     * @created 2016年4月4日 下午10:40:50
     * @since
     */
    public static void Test1() throws FileNotFoundException{
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
