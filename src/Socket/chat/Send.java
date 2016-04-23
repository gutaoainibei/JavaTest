package Socket.chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import TestIO.FileUtils;

/**
 * 
 * 描述：专门用于发送数据的线程
 * @author gt
 * @created 2016年4月22日 下午2:58:56
 * @since
 */
public class Send implements Runnable{
    private BufferedReader scannerin ;
    private DataOutputStream out;
    private boolean isRunning = true;
    public Send(){
    	scannerin = new BufferedReader(new InputStreamReader(System.in));
    }
    public Send(Socket client){
    	this();
    	try {
			out = new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			FileUtils.CloseAll(scannerin,out);
			isRunning = false;
			e.printStackTrace();
		}
    }
    public String getConsoleInfo() {
    	try {
			return scannerin.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
    }
    public void send(){
    	String info = getConsoleInfo();
		try {
			if(null != info && !(info.equals(""))){
			out.writeUTF(info);
			out.flush();
			}
		} catch (IOException e) {
			isRunning = false;
			FileUtils.CloseAll(scannerin,out);
			e.printStackTrace();
		}
    }
	@Override
	public void run() {
		while (isRunning) {
			send();
		}
	}

}
