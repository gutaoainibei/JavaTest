package designPattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 描述：抽象文件
 * @author gt
 * @created 2016年7月19日 下午11:41:55
 * @since
 */
public interface AbstractFile {
    void killVirus();
}
class TextFile implements AbstractFile{
	private String name;
	public TextFile(String name) {
		super();
		this.name = name;
	}
	public void killVirus() {
		System.out.println("杀除文本文件：" + name);
	}
}
class VideoFile implements AbstractFile{
	private String name;
	public VideoFile(String name) {
		super();
		this.name = name;
	}
	public void killVirus() {
		System.out.println("杀除视频文件：" + name);
	}
}
class MusicFile implements AbstractFile{
	private String name;
	public MusicFile(String name) {
		super();
		this.name = name;
	}
	public void killVirus() {
		System.out.println("杀除音乐文件：" + name);
	}
}
class Folder implements AbstractFile{
	private String name;
    List<AbstractFile> list = new ArrayList<AbstractFile>();
	public Folder(String name) {
		super();
		this.name = name;
	}
    public void add(AbstractFile file){
    	list.add(file);
    }
	 public void remove(AbstractFile file){
	   list.remove(file);
	 }
	 public AbstractFile getChild(int index){
	 	return list.get(index);
	 }
	public void killVirus() {
		System.out.println("杀除文件夹：" + name);
        for (AbstractFile file : list) {
			file.killVirus();
		}
	}
	
}