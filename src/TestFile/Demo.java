package TestFile;

import java.io.File;

public class Demo {
public static void main(String[] args) {
	Demo demo = new Demo();
	demo.ShowFileDirc(new File("G:/风为殇"), 0);
}
public void ShowFileDirc(File file , int level){
	for(int i = 0 ;i<level ; i++){
		System.out.print("-");
	}
	System.out.println(file.getName());
	if(file.isDirectory()){
		File[] files = file.listFiles();
        for(File tempfile : files){
        	ShowFileDirc(tempfile, level+1);
        }
	}
}
}
