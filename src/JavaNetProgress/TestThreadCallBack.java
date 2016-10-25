package JavaNetProgress;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.xml.bind.DatatypeConverter;

import oracle.net.aso.i;

/**
 * 
* @类名: TestThreadCallBack 
* @描述: TODO(这里用一句话描述这个类的作用) 
* @作者 gutao 
* @创建时间 2016年10月23日 下午8:59:28 
*
 */
public class TestThreadCallBack {
	
	private String fileName;
	private byte[] digest;
    public TestThreadCallBack(String fileName) {
		this.fileName = fileName;
	}
    public void callThread(){
    	callBackThread call = new callBackThread(fileName, this);
    	new Thread(call).start();
    }
	public static void main(String[] args) {
    	for(int i = 1 ; i < 3 ;i++){
    		TestThreadCallBack t1 = new TestThreadCallBack("H:/test/JAVA.txt");
    		t1.callThread();
    	}
	}

	public void receiveDigest(byte[] digest) {
		this.digest = digest;
		System.out.println(this);
	}
	@Override
	public String toString() {
		String result = fileName +":";
		if(digest != null){
			result += DatatypeConverter.printHexBinary(digest);
		}else{
           result += "digest not avaliable";			
		}
		return result;
	}
	
}
class callBackThread implements Runnable{
	private String fileName;
	private TestThreadCallBack callbackObj;
	public callBackThread(){}
	public callBackThread(String fileName, TestThreadCallBack callbackObj) {
		super();
		this.fileName = fileName;
		this.callbackObj = callbackObj;
	}
	
	public void run() {
		try {
			FileInputStream in = new FileInputStream(fileName);//"H:/test/JAVA.txt"
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			DigestInputStream digestInputStream = new DigestInputStream(in,sha); 
			while (digestInputStream.read() != -1) ;
			digestInputStream.close();
			byte[] digest = sha.digest();
			callbackObj.receiveDigest(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
