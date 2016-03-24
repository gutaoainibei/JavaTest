package TestIO;

import java.io.File;
/**
 * 描述：获取文件名称和路径
 *      路径分隔符：;
 *      文件分隔符：在windos下是\,linux下是/
 *      相对路径
 *      绝对路径
 * @author gt
 * @created 2016年3月23日 下午11:05:47
 * @since
 */
public class TestFileGetNameAndPath {
    public static void main(String[] args) {
		String path = "F:/JavaIO/gutao";
        String name = "gutao.txt";
        System.out.println("=============相对路径==================");
        //相对路径
		File file = new File(path,name);
		file = new File(new File(path), name);
		System.out.println("文件名称："+file.getName());
		System.out.println("父级目录："+file.getParent());
		System.out.println("当前路径："+file.getPath());
		System.out.println("绝对路径："+file.getAbsolutePath());
		//绝对路径
        System.out.println("=============绝对路径==================");
		file = new File("F:/JavaIO/gutao/gutao.jpg");
		System.out.println("文件名称："+file.getName());
		System.out.println("父级目录："+file.getParent());
		System.out.println("当前路径："+file.getPath());
		System.out.println("绝对路径："+file.getAbsolutePath());
		System.out.println("===============没有盘符构建================");
		//以系统属性user.dir 
		file = new File("gutao.txt");
		System.out.println("文件名称："+file.getName());
		System.out.println("父级目录："+file.getParent());
		System.out.println("当前路径："+file.getPath());
		System.out.println("绝对路径："+file.getAbsolutePath());

	}
    public static void testFileBaseMethod(){
    	File file = new File("t.txt");
		System.out.println("文件名："+file.getName());
		System.out.println("绝对路径："+file.getAbsoluteFile());
		System.out.println("同级所有目录文件名："+file.list());
		System.out.println("文件分隔符："+file.separatorChar);//在windos下是\,linux下是/
		System.out.println("路径分割符："+file.pathSeparator);//;
		System.out.println("父文件名:"+file.getParent());//获取抽象路径名的父路径名
		System.out.println(file.pathSeparatorChar);
		//路径的表达方式
		//1，这种方式不建议使用
		String path = "F:\\JavaIO\\gutao";
		//2如果路径是动态生成的建议使用这种方式
		path = "E:"+File.separator+"JavaIO"+File.separator+"gutao";
		//3,如果路径是死的，建议使用这种方式
		path = "F:/JavaIO/gutao";
    }
}
