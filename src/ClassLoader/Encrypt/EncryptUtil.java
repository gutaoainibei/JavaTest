package ClassLoader.Encrypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * 描述：简单加密class文件之后写出
 * @author gt
 * @created 2016年6月30日 下午11:12:03
 * @since
 */
public class EncryptUtil {
       public static void Encrypt(File src,File dest){
    	   FileInputStream inputStream = null;
    	   FileOutputStream outputStream = null;
    	   try {
			inputStream = new FileInputStream(src);
			outputStream = new FileOutputStream(dest);
			int temp = -1;
			while ((temp = inputStream.read())!=-1) {
				outputStream.write(temp^0xff);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
       }
}
