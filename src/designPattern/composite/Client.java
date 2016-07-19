package designPattern.composite;
/**
 * 
 * 描述：测试组合模式
 * @author gt
 * @created 2016年7月19日 下午11:41:14
 * @since
 */
public class Client {
    public static void main(String[] args) {
		AbstractFile f1,f2,f3,f4,f5;
		Folder folder = new Folder("我的文件");
		f2 = new MusicFile("雪");
		f3 = new VideoFile("舞蹈");
		folder.add(f2);
		folder.add(f3);
		
//		f2.killVirus();
		folder.killVirus();
	}
}
