package TestFile;

import java.io.File;
import java.io.IOException;

import com.mysql.jdbc.Field;

public class TestFile {
   public static void main(String[] args) {
	File file1 = new File("d:/Test.java");
	File file2 = new File("d:");
	File file3 = new File(file2, "Test.java");
	File file4 = new File("d:/test.txt");
	file4.delete();
	File file5 = new File("d:/aaa/ddd/ccc");
	
	file5.deleteOnExit();//从最深目录删，不能删根
	System.out.println(file1.isFile());
	System.out.println(file2.isDirectory());
	System.out.println(file3.isFile());
	
}
}
