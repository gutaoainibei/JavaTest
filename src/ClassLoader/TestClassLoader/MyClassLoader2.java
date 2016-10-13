package ClassLoader.TestClassLoader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


/**
 * 
 * 描述：实现自己定义的类加载器：
 * 自定义加载机制
 * @author gt
 * @created 2016年6月26日 下午4:25:36
 * @since
 */
public class MyClassLoader2 extends ClassLoader{
	//根目录
	private String rootdir;
	
	public MyClassLoader2(String rootdir){
		System.out.println("根路径："+rootdir);
		this.rootdir = rootdir;
	}
    public String getRootdir() {
		return rootdir;
	}

	public void setRootdir(String rootdir) {
		this.rootdir = rootdir;
	}

	@Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
       	//查看是否加载过这个类,如果已经加载了就直接返回已经加载的，如果没有就重新加载
		Class<?> c = null;//findLoadedClass(name);
		//采用自定义加载机制
		byte[] arrayCode = getClassCode(name);
		try {
			c = defineClass(name, arrayCode, 0,arrayCode.length);

		} catch (Exception e) {
			//e.printStackTrace();
		}
		//如果可以通过父类加载器得到
		if(c != null){
			return c;
		}else{
			//采用父类加载器
			ClassLoader classLoader = this.getParent();
			c = classLoader.loadClass(name);
		}
    	return c;
    }
	private byte[] getClassCode(String name) {
		String path = rootdir+"/"+name.replace(".", "/")+".class";
		System.out.println("路径："+path);
		InputStream inputStream =null;
		try {
			inputStream = new FileInputStream(path);
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] flush = new byte[1024];
            int temp = 0;
            while ((temp = inputStream.read(flush))!=-1) {
				outStream.write(flush, 0, temp);
			}
            return outStream.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}finally{
			try {
				if(inputStream!=null){
				  inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
