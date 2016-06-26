package ClassLoader.TestClassLoader;
/**
 * 
 * 描述：实现自己定义的类加载器：
 * @author gt
 * @created 2016年6月26日 下午4:25:36
 * @since
 */
public class MyClassLoader extends ClassLoader{
	//根目录
	private String rootdir;
	
	public MyClassLoader(String rootdir){
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
			c = classLoader.loadClass(name);
			//如果可以通过父类加载器得到
			if(c != null){
				return c;
			}else{
				MyClassLoader myClassLoader = new MyClassLoader(rootdir);
			}
		}
    	return super.findClass(name);
    }
}
