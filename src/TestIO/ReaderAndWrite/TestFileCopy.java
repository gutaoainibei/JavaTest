package TestIO.ReaderAndWrite;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/**
 * 
 * 描述：字符流拷贝
 *      处理流增强功能，提高性能，节点流之上
 *      一、缓冲流
 *         1）、字节缓冲流
 *         BufferedInputStream  read(byte[] b)
 *         BufferedOutputStream write(byte[] b ,int off,int len)
 *         2）、字符流
 *         BufferedReader  readLine();
 *         BufferedWriter  newLine();
 *      二、字节流与字符流的转换
 *         InputSteamReader：解码，可以加上解码集
 *         OutputSreamWriter：编码，可以加上编码集
 * @author gt
 * @created 2016年3月28日 下午6:20:58
 * @since
 */
public class TestFileCopy {
   public static void main(String[] args) throws IOException {
        String srcPath = "F:/JavaIO/gutao.txt";
        String destPath = "F:/JavaIO/gutao1.txt";
        //这里只是为了展示一下字节流到字符流的转换通过inputStreamReader
        //建立连接
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(srcPath)),"gbk"));
        //写出的时候进行转流，字节流转换成字符流可以进行转码，读入流是解码，写出流失编码，FileOutputStream(file,boolean)第二个参数是用来判断新内容是追加还是覆盖
        //true是追加，false是覆盖，默认是覆盖
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(destPath),true),"utf-8"));
        String string = null;
        while ((string = reader.readLine())!=null) {
			 writer.write(string);
			 writer.newLine();
		}
        writer.flush();
        reader.close();
        writer.close();
   }
}
