package TestIO.dataStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 描述：处理流
 *     输出流：DataInputStream 
 *     输出流：DataOutputStream
 *     新增方法就不能用多态
 * @author gt
 * @created 2016年3月30日 下午6:07:04
 * @since
 */
public class TestDataStream {
    public static void main(String[] args) throws IOException {
		//write("F:/JavaIO/serizable.txt");
		read("F:/JavaIO/serizable.txt");

	}
    public static void read(String strPath) throws IOException{
    	//建立联系
    	File file = new File(strPath);
    	//选择流
    	DataInputStream datain = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
    	//如果这里顺序和之前序列化的顺序不一样，那么就会乱码
    	//所以这里必须是，序列化和反序列化的顺序一样
    	System.out.println("浮点数："+datain.readDouble());
    	System.out.println("整数："+datain.readInt());
        System.out.println("字符串："+datain.readUTF());
        datain.close();
    }
    /**
     * 
     * 描述：
     * @author gt
     * @created 2016年3月30日 下午11:53:17
     * @since 
     * @param strPath:序列化的文件
     * @throws IOException
     */
    public static void write(String strPath) throws IOException{
    	double d = 3.2;
    	int i = 5;
    	String str = "数据类型";
    	//建立联系，创建源
    	File file = new File(strPath);
    	//选择流
    	DataOutputStream dataout = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        //写入的顺序和读取顺序要一致
    	dataout.writeDouble(d);
        dataout.writeInt(i);
        dataout.writeUTF(str);
        dataout.flush();
        dataout.close();
    }
}
