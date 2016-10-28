package common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 
 * 描述：更新公司框架测试类
 * @author gt
 * @created 2016年10月11日 上午10:15:37
 * @since
 */
public class updateFile {
	/**
	 * 换行符
	 */
	private static final String CRLF = "\r\n";
	/**
	 * 模板内容
	 */
	static String modelStr = "";
	/**
	 * 
	 * 描述：升级文件
	 * @author gt
	 * @created 2016年10月26日 上午10:51:23
	 * @since 
	 * @param path 需要升级的文件路径
	 */
    public static void updateHtml(String path,String modelPath) {
    	 modelStr = getModelHtml(modelPath);
	    listAllhtml(path);
    }
    /**
     * 
     * 描述：获取模板的内容
     * @author gt
     * @created 2016年10月26日 上午10:52:25
     * @since 
     * @param modelPath 模板路径
     * @return
     */
    public static String getModelHtml(String modelPath){
    	StringBuffer modelHtmlStr = new StringBuffer();
    	BufferedReader reader = null;
    	try {
			reader = new BufferedReader(new FileReader(modelPath));
			String temp = "";
			while ((temp = reader.readLine()) != null) {
				modelHtmlStr.append(temp).append(CRLF);
			}
			return modelHtmlStr.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}finally{
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    } 
    /**
     * 
     * 描述：遍历所有需要升级的文件
     * @author gt
     * @created 2016年10月26日 上午10:52:53
     * @since 
     * @param path
     */
    public static void listAllhtml(String path){
    	if(path == null || path.trim().length()<1){
    		return ;
    	}
    	File file = new File(path);
    	int count = 0;
    	if(file.isDirectory()){
    		System.out.println("文件夹路径："+file.getAbsolutePath());
    		System.out.println("文件夹名:"+file.getName());
    		String[] filename = file.list();
    		for (String string : filename) {
				listAllhtml(file.getAbsolutePath()+"\\"+string);
			}
    	}else{
    		createFile(file,"F:/savePath");//创建新的html文件,并指定要放到那个目录下
    	}
    }
    /**
     * 
     * 描述：创建文件
     * @author gt
     * @created 2016年10月26日 上午10:53:18
     * @since 
     * @param filehtml
     * @param savaPath
     */
    public static void createFile(File filehtml,String savaPath){
    	String ablutePath = filehtml.getAbsolutePath().replace("\\", "/");
    	String htmlPath = ablutePath.substring(ablutePath.indexOf("m/")+2, ablutePath.lastIndexOf("/"))+"/"+filehtml.getName();
    	String scriptSrc = htmlPath.replace("views", "scripts").replace(".html", ".js");//div标签中的js路径
    	String newPath = savaPath + "/" + htmlPath.substring(0, htmlPath.lastIndexOf("/"));
    	System.out.println("js应该在的路径："+scriptSrc);
		System.out.println("新文件所在路径："+newPath);
    	File parenfile = new File(newPath);
		if(!parenfile.exists()){//如果文件不存在
			parenfile.mkdirs();
		}
		String fileName = filehtml.getName();
		StringBuffer html = new StringBuffer();
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(filehtml));
			String temp = "";
			while ((temp=fileReader.readLine()) != null) {
				html.append(temp).append(CRLF);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		html.insert(html.indexOf("class=\"page\"")+"class=\"page\"".length(), " data-script='"+scriptSrc+"'");
        String resultStr = html.toString().replaceAll("class=\"page\"", " class=\"page page-current\"").replace("data-refresh=\"yes\"", "data-refresh=\"true\"");
        resultStr = modelStr.replace("oldpageCode", resultStr);
        File file = new File(parenfile.getAbsoluteFile()+"/"+filehtml.getName());
        try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
			bufferedWriter.write(resultStr);
			bufferedWriter.flush();
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    } 
}
