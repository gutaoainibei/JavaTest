package TestIO.byteArrayStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

public class ByteArrayStream {
    public static void main(String[] args) throws IOException {
		testByteArrayStream();
		ByteWriteInFile(getByteArrayFromFile("F:/JavaIO/gutao.txt"));
	}
    public static void ByteWriteInFile(byte[] b) throws IOException{
    	InputStream in = new BufferedInputStream(new ByteArrayInputStream(b));
    	BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("F:/JavaIO/gutao1.txt"),true)));
    	byte[] bt = new byte[1024];
    	int len = 0;
     	while((len = in.read(bt))!=-1){
            out.newLine();
     		out.write(new String(bt,"gbk"));		
    	}
     	out.flush();
     	out.close();
    }
    /**
     * 
     * 描述：
     * @author gt
     * @created 2016年3月29日 下午9:02:18
     * @since 
     * @param filepath：读取的文件路径
     * @return
     * @throws IOException
     */
    public static byte[] getByteArrayFromFile(String filepath) throws IOException{
        File file = new File(filepath);	
        InputStream inputStream  = new BufferedInputStream(new FileInputStream(file));
		byte[] result = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 	
        byte[] b = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(b))!=-1) {
			outputStream.write(b, 0, len);
		}
        outputStream.flush();
        result = outputStream.toByteArray();
        outputStream.close();
        inputStream.close();
    	return result;
    }
    /**
     * 
     * 描述：测试字节流的读入和写出
     * @author gt
     * @created 2016年3月29日 下午9:02:40
     * @since 
     * @throws IOException
     */
    public static void testByteArrayStream() throws IOException{
    	String str = "顾涛爱倪贝";
    	byte[] b = str.getBytes();
    	//字节输入流
    	InputStream inbyte = new BufferedInputStream(new ByteArrayInputStream(b));
    	ByteArrayOutputStream outbyte = new ByteArrayOutputStream();
    	byte[] bt = new byte[1024];
    	int len = 0;
    	while((len = inbyte.read(bt))!=-1){
    		outbyte.write(bt, 0, len);
    	}
    	outbyte.flush();
    	byte[] resultByte = outbyte.toByteArray();
    	inbyte.close();
    	outbyte.close();
    	System.out.println(new String(resultByte));
    }
}
