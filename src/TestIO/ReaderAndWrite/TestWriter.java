package TestIO.ReaderAndWrite;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
/**
 * 
 * 描述：字符流文件的写出，只能是纯文本
 * @author gt
 * @created 2016年3月28日 下午6:18:30
 * @since
 */
public class TestWriter {
   public static void main(String[] args) throws IOException {
	     //文件路径
		 String srcPath = "F:/JavaIO/gutao1.txt";
		 //建立联系
		 File file = new File(srcPath);
		 Writer writer = new FileWriter(file,true);
		 //处理流，增强处理性能
		 BufferedWriter buffReader = new BufferedWriter(writer);
		 String string = "菩提本无树\r\n明镜亦非台\r\n本来无一物\r\n何处染尘埃";
//		 writer.write(string);
//		 writer.flush();
//		 writer.close();
		 System.out.println("========增强===========");
	     buffReader.write(string);
	     buffReader.newLine();
	     buffReader.flush();
	     buffReader.close();

}
}
