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
 * 描述：把原型页面改成我们需要的很h5
 * @author gt
 * @created 2016年10月13日 下午3:17:19
 * @since
 */
public class changePageToH5 {
	//换行符
		private static final String CRLF = "\r\n";
		private static final String MODELPATH = "F:/modle/page/oldModel.html";
	    private static String modelStr = "";
	    static{
	    	modelStr = getModelHtml(MODELPATH);
	    }
		
		public static void main(String[] args) {
			String path = "D:/develop/workspace1/thinkive-sj1-YTG-web/src/main/webapp/m/ytg/views";
		    listAllhtml(path);
	    }
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
	    		createFile(file);//创建h5的html文件,并指定要放到那个目录下
	    	}
	    }
	    
	    public static void createFile(File filehtml){
	    	String ablutePath = filehtml.getAbsolutePath().replace("\\", "/");
	    	String htmlPath = ablutePath.substring(ablutePath.indexOf("m/")+2, ablutePath.lastIndexOf("/"))+"/"+filehtml.getName();
	    	String scriptSrc = htmlPath.replace("views", "scripts").replace(".html", ".js");//div标签中的js路径
	    	System.out.println("js应该在的路径："+scriptSrc);
			System.out.println("新文件所在路径："+filehtml.getParent());
			String pageCode = scriptSrc.substring(scriptSrc.indexOf("scripts/")+"scripts/".length()).replace(".js", "").replace("/", "_");
			System.out.println("当前的pageCode："+pageCode);
	    	File parenfile = new File(filehtml.getParent());
			if(!parenfile.exists()){//如果文件不存在
				parenfile.mkdirs();
			}
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
			String mainStr = html.substring(html.indexOf("<section"),html.indexOf("</section>")+"</section>".length()).replaceAll("#", "javascript:void(0);");
			String resultStr = modelStr.replace("gtscriptSrc", scriptSrc).replace("gtpageCode",pageCode).replace("gthtmlConstant", mainStr);
	        System.out.println("模板代码："+modelStr);
			System.out.println("更具原型生成的html:"+resultStr);
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
