package TestIO.FileIO;
/**
 * 
 * 描述：描述IO流
 *      流：流动、从一端移动到另一端 源头与目的地
 *      程序 与 文件|数组|网路连接|数据库，以程序为中心
 *      二、IO流分类
 *      1、流向：输入流与输出流
 *      2、 数据： 字节流：二进制，可以是一切文件包括：纯文本 doc 音频 视频等等
 *              字符集：文本文件，只能处理纯文本
 *      3、功能 节点：包裹源头
 *            处理：增强功能，提供功能
 *      三、字节流与字符流（重中之重）与文件
 *      1、 字节流
 *         输入流：InputStream read(byte[] b)、read(byte[] b,int off,int len) close();
 *               FileInputStream();
 *         输出流:OutputStream write(byte[] b) write(byte[] b, int off, int len) +flush() +close();
 *               FileOutputStream();
 *      2、字符流
 *         输入流：Reader read(char[] c) read(char[] c,int off,int len)+close();
 *               FileReader()
 *         输出流：Writer write(char[] c) write(char[] c,int off ,int len) +flush() +close();
 *               writer(String str,int off,int len)
 *               FileWriter()
 *      四、操作
 *         1、举列 搬家             -->读取文件
 *            关联房子             -->建立与文件联系
 *            选择搬家             -->选择对应流
 *            搬家                    -->读取|写出
 *               a.卡车大小  -->数组大小
 *               b.运输         -->读出、写出
 *            打发over     -->释放资源
 *          2、操作
 *            1)建立联系
 *            2）选择流
 *            3）操作 数组大小 read、write     
 * @author gt
 * @created 2016年3月27日 下午11:05:13
 * @since
 */
public class FileIO {
    public static void main(String[] args) {
		
	}
}
