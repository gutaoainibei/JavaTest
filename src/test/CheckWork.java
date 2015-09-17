package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.ParseConversionEvent;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

public class CheckWork {
	private static ArrayList<String> filelist = new ArrayList<String>();
	static int normmalrow = 0;
	static int spacerow = 0;
	static int explainrow = 0;
	static int shortrow = 0;
 public static void main(String[] args) {
	String filepath = "G:\\MyEclipseWorkSpace";
	getFile(filepath);
	int i = 0;
	for(String child : filelist){
		if(child.matches(".*\\.java$")){
			i++;
			parse(child);
		}
	}
	System.out.println("在"+filepath+"中共写了"+i+"个java文件");
	System.out.println("一共写了："+(normmalrow+explainrow+spacerow)+"行java代码");
	System.out.println("行长度少于8的有："+shortrow+"行");
	System.out.println("有空白行："+spacerow+"行");
	System.out.println("代码行："+normmalrow+"行");
	System.out.println("注释行："+explainrow+"行");
}

private static void parse(String child) {
	// TODO Auto-generated method stub
	BufferedReader bufferedReader = null;
	boolean comments =false;
	try {
		bufferedReader = new BufferedReader(new FileReader(child));
		String line ="";
	
		while((line = bufferedReader.readLine())!=null){
			line = line.trim();
			if(line.matches("^[\\s&&[^\\n]]*$")){
				spacerow++;
			}else if(line.startsWith("/*") && !line.endsWith("*/")){
                explainrow++;
                comments = true;
                
			}else if(true == comments){
                 explainrow++;
                 if(line.endsWith("*/")){
                	 comments = false;
                 }
			}else if(line.startsWith("//")){
				explainrow++;
			}else if(line.startsWith("/*")&&line.endsWith("*/")){
				explainrow++;
			}else{
				if(line.length()<8){
					shortrow++;
				}
				normmalrow++;
			}
		}
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		if(bufferedReader != null) {
			try {
				bufferedReader.close();
				bufferedReader = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
static void getFile(String filePath){
	File rootFile = new File(filePath); 
	File[] files = rootFile.listFiles();
	for(File file : files){
		if(file.isDirectory()){
			getFile(file.getAbsolutePath());
			filelist.add(file.getAbsolutePath());
		}else{
			filelist.add(file.getAbsolutePath());
		}
	}
	
}
}
