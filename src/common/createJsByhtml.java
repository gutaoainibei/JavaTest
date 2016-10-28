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
 * 描述：根据对应的html生成对应的js
 * @author gt
 * @created 2016年10月12日 下午3:00:27
 * @since
 */
public class createJsByhtml {
	    /**
	     * 换行符
	     */
		private static final String CRLF = "\r\n";
		/**
		 * 模板js
		 */
		private static String modelJs = "";
		/**
		 * js的保存路径
		 */
		private static String jsPath = "";
		/**
		 * 
		 * 描述：创建页面答应的js
		 * @author gt
		 * @created 2016年10月26日 上午11:10:08
		 * @since 
		 * @param htmlPath  需要创建js的html路径
		 * @param modelPath js模板路径
		 */
	    public static void createJs(String htmlPath,String modelPath) {
	    	modelJs = getModelStr(modelPath);
			jsPath = htmlPath.substring(0, htmlPath.indexOf("m/")+"m/".length());
			System.out.println(jsPath);
			getJsOfHtml(htmlPath,modelJs);
			
	    }
	    /**
	     * 
	     * 描述：返回js生成模板的字符串
	     * @author gt
	     * @created 2016年10月13日 下午3:04:12
	     * @since 
	     * @param modelStr
	     * @param pageCOde
	     * @param path
	     * @return
	     */
	    public static String getJsConstant(String modelStr,String pageCOde,String path){
	    	return modelStr.replace("pathSrc", path).replace("pageCodeModel", pageCOde).replace("pageIdModel", pageCOde.replace("/", "_"));
	    } 
	    /**
	     * 
	     * 描述：遍历所有的html文件
	     * @author gt
	     * @created 2016年10月13日 下午3:03:40
	     * @since 
	     * @param path
	     * @param modelJs
	     * @return
	     */
	    public static String getJsOfHtml(String path,String modelJs){
	    	if(path == null || path.trim().length()<1){
	    		return null;
	    	}
	    	File file = new File(path);
	    	if(file.isDirectory()){
	    		System.out.println("文件夹路径："+file.getAbsolutePath());
	    		System.out.println("文件夹名:"+file.getName());
	    		String[] filename = file.list();
	    		for (String string : filename) {
	    			getJsOfHtml(file.getAbsolutePath()+"\\"+string,modelJs);
				}
	    	}else{
	    		createFile(file,jsPath,modelJs);//创建新的html文件,并指定要放到那个目录下
	    	}
	    	return null;
	    }
	    /**
	     * 
	     * 描述：创建对应的js文件
	     * @author gt
	     * @created 2016年10月13日 下午3:03:20
	     * @since 
	     * @param filehtml
	     * @param savaPath
	     * @param modelStr
	     */
	    public static void createFile(File filehtml,String savaPath,String modelStr){
	    	String ablutePath = filehtml.getAbsolutePath().replace("\\", "/");
	    	String scriptPath = ablutePath.substring(ablutePath.indexOf("m/")+2, ablutePath.lastIndexOf("/"))+"/"+filehtml.getName();
	    	String scriptDefPath = scriptPath.replace("views", "scripts").replace(".html", "");
	    	String paageCode = scriptDefPath.substring(scriptDefPath.indexOf("scripts/")+"scripts/".length());
	    	String newFolderPath = savaPath+scriptDefPath.substring(0, scriptDefPath.lastIndexOf("/"));
	    	String jsStr = getJsConstant(modelStr, paageCode, scriptDefPath);
	    	System.out.println(scriptDefPath);
	    	System.out.println(newFolderPath);
	    	File parenfile = new File(newFolderPath);
			if(!parenfile.exists()){//如果文件不存在
				parenfile.mkdirs();
			}
	        File file = new File(parenfile.getAbsoluteFile()+"/"+filehtml.getName().replace(".html", ".js"));
	        try {
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
				bufferedWriter.write(jsStr);
				bufferedWriter.flush();
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    } 
	    /**
	     * 
	     * 描述：获取模板内容
	     * @author gt
	     * @created 2016年10月26日 上午11:04:40
	     * @since 
	     * @param pathString
	     * @return
	     */
	    public static String getModelStr(String pathString){
	    	BufferedReader reader = null;
	    	StringBuffer stringBuffer  = new StringBuffer();
	    	 try {
				 reader = new BufferedReader(new FileReader(pathString));
				 String temp = "";
				 while ((temp = reader.readLine()) != null) {
					   stringBuffer.append(temp).append(CRLF);
				}
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
	    	return stringBuffer.toString();
	    }
}
