package TestIO.ReaderAndWrite;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
/**
 * 
 * 描述：Reader字符流读取，和增强字符流BufferedReader，只能是纯文本
 * @author gt
 * @created 2016年3月28日 下午5:02:19
 * @since
 */
public class TestReader {
   public static void main(String[] args) throws IOException {
	 //文件路径
	 String srcPath = "F:/JavaIO/gutao1.txt";
	 //建立联系
	 File file = new File(srcPath);
	 Reader reader = new FileReader(file);
//	 int len = 0;
//	 //与字节流相比，这是把byte变成了char
//	 char[] c = new char[100];
//	 //这里与字节一样
//	 while ((len=reader.read(c))!=-1) {
//		System.out.println(new String(c,0,len));
//	 }
	 System.out.println("=============增强处理==================");
	 //处理流，增强处理性能
	 BufferedReader buffReader = new BufferedReader(reader);
	 String string = null;
	 while((string=buffReader.readLine())!=null){
		 System.out.println(string);
	 }
	 reader.close();
}
}
