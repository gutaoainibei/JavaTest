package Socket.chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import TestIO.FileUtils;

/**
 * 
 * 描述：接收消息
 * @author gt
 * @created 2016年4月22日 下午3:29:20
 * @since
 */
public class Receive implements Runnable{
    private DataInputStream reader;
    private boolean isRunning = true;
    public Receive(){
    	
    }
    public Receive(Socket client){
    	try {
			reader = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			isRunning = false;
			FileUtils.CloseAll(reader);
			e.printStackTrace();
		}
    }
    public void receive(){
    	try {
			System.out.println(reader.readUTF());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    @Override
	public void run() {
		while (isRunning) {
			receive();
		}
	}
     
}
