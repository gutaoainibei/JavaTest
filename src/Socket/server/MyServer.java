package Socket.server;

import java.io.IOException;
import java.net.ServerSocket;
/**
 * 描述：实现自己简单服务器
 *    协议
 *    1）应用层HTTP FTP TELNET SNMP DNS
 *    2)传输层 TCP UDP
 *    3)网路层IP
 *    4）主机-网络层  以太网 IEEE802.3 令牌环网：IEEE802.4
 *    HTTP（Hypertext Transfer Protocol）是网络应用层的协议，建立
 *    在TCP/IP协议基础上，HTTP协议使用可靠的TCP连接，默认端口为80，目前
 *    最新 的版本为HTTP2.0，对应的RFC文档为RFC2068
 *    
 *    Http协议请求格式
 *    1）请求方式  URL（统一资源定位符）  Http协议/版本
 *    2）请求头（Request Header）
 *    3）请求正文（Request Content）
 *          例如：
 *          POST /index.html HTTP/1.1
			Host: localhost:8888
			Connection: keep-alive
			Content-Length: 35（这里是字节数）
			Cache-Control: max-age=0
			Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp;q=0.8
			Origin: null
			Upgrade-Insecure-Requests: 1
			User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36
			Content-Type: application/x-www-form-urlencoded
			Accept-Encoding: gzip, deflate
			Accept-Language: zh-CN,zh;q=0.8

            username=%B9%CB%CC%CE&password=1111
 *    Http协议响应格式
 *    1）Http协议版本 状态码 描述（两两之间有一个空格）
 *    2）响应头(Response Head)
 *    3)响应正文(Response Content)
 *   
 *    常见类型:
 *    
 *    
 *    头字段                                    定义
      Accept               客户端可以处理的媒体类型（MIME-Type），按优先级排序；在一个以逗号为分隔的列表中，可以定义多种类型和使用通配符
      Accept-Language      客户端支持的自然语言列表
      Accept-Encoding      客户端支持的编码列表
      User-Agent           客户端环境类型
      Host                 服务器端的主机地址
      Connection           连接类型，默认为Keep-Alive
 *    
 *    状态码                                    定义
       1xx                 报告接收到请求，继续进程
       2xx                 成功步骤成功接收，被理解，并被接受
       3xx                 重定向为了完成请求,必须采取进一步措施
       4xx                 客户端出错请求包括错的顺序或不能完成
       5xx                 服务器出错服务器无法完成显然有效的请求
       下面列举了为HTTP/1.1定义的状态码值，和对应的原因短语（Reason-Phrase）的例子。
		l  客户端错误
		"100" : Continue  继续
		"101" : witching Protocols  交换协议
		l  成功
		"200" : OK
		"201" : Created 已创建
		"202" : Accepted 接收
		"203" : Non-Authoritative Information 非认证信息
		"204" : No Content 无内容
		"205" : Reset Content 重置内容
		"206" : Partial Content 部分内容
		l  重定向
		"300" : Multiple Choices 多路选择
		"301" : Moved Permanently  永久转移
		"302" : Found 暂时转移
		"303" : See Other 参见其它
		"304" : Not Modified 未修改
		"305" : Use Proxy 使用代理
		"307" : Temporary Redirect
		l  客户方错误
		"400" : Bad Request 错误请求
		"401" : Unauthorized 未认证
		"402" : Payment Required 需要付费
		"403" : Forbidden 禁止
		"404" : Not Found 未找到
		"405" : Method Not Allowed 方法不允许
		"406" : Not Acceptable 不接受
		"407" : Proxy Authentication Required 需要代理认证
		"408" : Request Time-out 请求超时
		"409" : Conflict 冲突
		"410" : Gone 失败
		"411" : Length Required 需要长度
		"412" : Precondition Failed 条件失败
		"413" : Request Entity Too Large 请求实体太大
		"414" : Request-URI Too Large 请求URI太长
		"415" : Unsupported Media Type 不支持媒体类型
		"416" : Requested range not satisfiable
		"417" : Expectation Failed
		l  服务器错误
		"500" : Internal Server Error 服务器内部错误
		"501" : Not Implemented 未实现
		"502" : Bad Gateway 网关失败
		"503" : Service Unavailable
		"504" : Gateway Time-out 网关超时
		"505" : HTTP Version not supported  HTTP版本不支持
 *    
 * @author gt
 * @created 2016年4月24日 下午10:58:37
 * @since
 */
public class MyServer {
    private ServerSocket server;
    private static final String CRLF="\r\n";
    private static final String BLANK=" ";
    private boolean runningAble = true;
    public static void main(String[] args) {
		MyServer serverTest = new MyServer();
		serverTest.start(8888);
	}
    /**
     * 
     * 描述：启动服务器
     * @author gt
     * @created 2016年4月25日 下午11:37:53
     * @since
     */
    private void start(int port){
    	try {
			server = new ServerSocket(port);
			this.receive();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    /**
     * 
     * 描述：接受请求
     * @author gt
     * @created 2016年4月25日 下午11:37:57
     * @since
     */
    private void receive(){
    	try {
    		while (runningAble) {
    			//为每一个客户请求new一个线程处理，这里加入了Dispatcher转发类
    			//Dispatcher是一个转发线程类，对每一个请求，new一个Servlet处理
    			new Thread(new Dispatcher(server.accept())).start();
			}
    	} catch (IOException e) {
    		stop();
			e.printStackTrace();
		}
    }
    /**
     * 
     * 描述：停止服务器
     * @author gt
     * @created 2016年4月25日 下午11:38:02
     * @since
     */
    private void stop(){
    	runningAble = false;
    	try {
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
