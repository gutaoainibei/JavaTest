package TestIO.FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 
 * 描述：写入
 * @author gt
 * @created 2016年3月28日 上午12:17:58
 * @since
 */
public class FileOut {
     public static void main(String[] args) {
    	//建立联系
 		File file = new File("F:/JavaIO/gutao.txt");
 		OutputStream out = null;
        try {
        	 //选择流
			 out = new FileOutputStream(file,true);
			 //写入字符串
			 String string = "gutao ai nibei\r\n";
			 //操作不断写入，缓冲数组
			 byte[] b = string.getBytes();
			 out.write(b, 0, b.length);
		} catch (FileNotFoundException e) {
			System.out.println("文件找不到");
			e.printStackTrace();
		} catch (IOException e) {
            System.out.println("文件读取失败");
			e.printStackTrace();
		}finally{
			if(null != out){
                try {
					out.close();
				} catch (IOException e) {
					System.out.println("文件流关闭失败");
					e.printStackTrace();
				}
			}
		}
        
	}
}
