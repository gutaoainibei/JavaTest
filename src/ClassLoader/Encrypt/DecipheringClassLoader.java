package ClassLoader.Encrypt;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * 
 * 描述：解密加载器
 * @author gt
 * @created 2016年6月30日 下午11:32:16
 * @since
 */
public class DecipheringClassLoader extends ClassLoader{
	//根目录
		private String rootdir;
		
		public DecipheringClassLoader(String rootdir){
			this.rootdir = rootdir;
		}
	    public String getRootdir() {
			return rootdir;
		}

		public void setRootdir(String rootdir) {
			this.rootdir = rootdir;
		}

		@Override
	    protected Class<?> findClass(String name) throws ClassNotFoundException {
	       	//查看是否加载过这个类,如果已经加载了就直接返回已经加载的，如果没有就重新加载
			Class<?> c = findLoadedClass(name);
			if(c != null){
				return c;
			}else{
				//采用默认的双亲委托加载机制
				ClassLoader classLoader = this.getParent();
				System.out.println(classLoader);
				try {
					c = classLoader.loadClass(name);
				} catch (Exception e) {
					//e.printStackTrace();
				}
				//如果可以通过父类加载器得到
				if(c != null){
					return c;
				}else{
					byte[] arrayCode = getClassCode(name);
					if(arrayCode == null){
						throw new ClassNotFoundException();
					}else{
						//导入类到方法区
						c = defineClass(name, arrayCode, 0,arrayCode.length);
					}
				}
			}
	    	return c;
	    }
		private byte[] getClassCode(String name) {
			String path = rootdir+"/"+name.replace(".", "/")+".class";
			InputStream inputStream =null;
			try {
				inputStream = new FileInputStream(path);
				ByteArrayOutputStream outStream = new ByteArrayOutputStream();
	            int temp = -1;
	            while ((temp = inputStream.read())!=-1) {
					outStream.write(temp^0xff);
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
