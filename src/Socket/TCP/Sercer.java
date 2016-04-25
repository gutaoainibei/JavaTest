package Socket.TCP;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;



/**
 * 
 * 描述：基于tcp协议的服务端
 * @author gt
 * @created 2016年4月22日 上午10:00:46
 * @since
 */
public class Sercer {
     public static void main(String[] args) throws IOException {
    	//创建服务器端，指定端口
		ServerSocket server = new ServerSocket(8888);
		//接收客户端请求，这里为阻塞式
		Socket socket  = server.accept();
		OutputStream out = socket.getOutputStream();
		System.out.println("一个客户端连接了");
	    BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(out));
	   
		String msg = "欢迎你的连接";
	    buf.write(msg);
	    //这里如果接收端用的是readline(),这里就必须加上，
	    buf.newLine();
	    buf.flush();
	    // //因为这个方法是以回车会结束标识的,如果输出流关闭，这里不加newline（）也可以
	    //这里我也是没太弄清，为什么close()会结束文件写出回车结束，强制flush()，所以说close()等于上面两句的效果
	    //buf.close();
		//通过数据流在传输
//		 DataOutputStream  dataOutputStream = new DataOutputStream(out);
//		 dataOutputStream.writeUTF(msg);
//		 dataOutputStream.flush();
//		 dataOutputStream.close();
 	}
}
