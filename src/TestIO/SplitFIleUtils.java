 package TestIO;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * 描述：分割文件的工具类实现
 * @author gt
 * @created 2016年4月6日 下午11:51:42
 * @since
 */
public class SplitFIleUtils {
	 //要分割的文件路径
     private String filePath;
     //文件名称
     private String fileName;
     //文件的总字节数
     private long length;
     //每一块大小
     private long blockSize;
     //块数
     private int size;
     //模块路径
     private List<String> blockPathList;
     public SplitFIleUtils(){
    	 blockPathList = new ArrayList<String>();
     }
     public SplitFIleUtils(String filePath){
    	 this(filePath,1024L);
     }
     public SplitFIleUtils(String filePath,long blockSize){
    	 this();
    	 this.filePath = filePath;
    	 this.blockSize = blockSize;
    	 init();
     }
     /**
      * 
      * 描述：初始化各个参数
      * @author gt
      * @created 2016年4月7日 下午11:10:53
      * @since
      */
     public void init(){
    	 File file = new File(filePath);
    	 if(null == filePath && !(file.exists())){
    		 System.out.println("文件不存在！");  
    		 return;
    	 }
    	 if(file.isDirectory()){
    		 System.out.println("分割目标不是文件");
    		 return;
    	 }
    	 length = file.length();
    	 fileName = file.getName();
    	 if(length < blockSize){
    		 blockSize = length;
    	 }
    	 size = (int)Math.ceil(length*1.0/blockSize);
     }
     /**
      * 
      * 描述：分割文件路径初始化
      * @author gt
      * @created 2016年4月7日 下午11:26:45
      * @since 
      * @param destPath
     * @throws IOException 
      */
     public void Split(String destPath) throws IOException{
    	 File fileDirectory = new File(destPath);
    	 if(!(fileDirectory.isDirectory())){
    		 System.out.println("目标目录不存在");
    		 return;
    	 }
    	 long  autualBlockSize = blockSize;
    	 long  beginIndex = 0L;
    	 for (int i = 0; i < size; i++) {
    		
			blockPathList.add(destPath+"/"+fileName+"block-"+i);
			if(i == size-1){
				//最后一块的实际大小
				autualBlockSize = length-(size-1)*blockSize;
			}
			beginIndex = i*blockSize;
			SplitDetail(destPath+"/"+fileName+"block-"+i,beginIndex,autualBlockSize);
		 }
    	 
     }
     /**
      * 
      * 描述：实现分割
      * @author gt
      * @created 2016年4月8日 上午12:01:04
      * @since 
      * @param destBlockPath 目标块的路径
      * @param beginIndex  读取的起始位置
      * @param autualBlockSize 实际块的大小
      * @throws IOException
      */
     public void SplitDetail(String destBlockPath,long beginIndex,long autualBlockSize) throws IOException{
    	   File file = new File(this.filePath);
    	   RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
    	   randomAccessFile.seek(beginIndex);
    	   byte[] flush = new byte[1024];
    	   int len = 0;
    	   BufferedOutputStream  bufferedStream = new BufferedOutputStream(new FileOutputStream(new File(destBlockPath),true));
           while (-1!=(len = randomAccessFile.read(flush))) {
        	    if(autualBlockSize-len > 0){
        	    	bufferedStream.write(flush, 0, len);
        	    	autualBlockSize -= len;
        	    }else {
        	    	bufferedStream.write(flush, 0, (int)autualBlockSize);
        	    	break;
				}
 		   }
           FileUtils.Close(randomAccessFile,bufferedStream);
     }
     public static void main(String[] args) throws IOException {
		SplitFIleUtils splitFIleUtils = new SplitFIleUtils("F:/JavaIO/lm/1.jpg", 5000);
	    splitFIleUtils.Split("F:/JavaIO/lm");
     }
}
