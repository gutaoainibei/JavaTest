package TestIO.dataStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import TestIO.dataStream.model.Employee;
import TestIO.dataStream.model.NoSerializable;



/**
 * 
 * 描述：引用类型的序列化
 *     反序列化 输入流 ObjectInputStream readObject();
 *     序列化 输出流 ObjectOutputStream writeObject();
 *     注意：
 *     1、先序列化再反序列化：序列化和反序列化的顺序必须一致
 *     2、不是所有的对象都可以序列化：java.io.Serializable
 *        不是所有的属性都需要序列化：transient
 * @author gt
 * @created 2016年3月31日 上午12:34:02
 * @since
 */
public class RefrenceObjectStream {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
    	//这里是可以实现序列化的
    	write("F:/JavaIO/serizable.txt");
    	//读取第一个满足的对象序列
    	read("F:/JavaIO/serizable.txt");
    	//java.io.NotSerializableException:这是没有实现serializable接口的原因
    	//writeNoSerializable("F:/JavaIO/noserializable.txt");
    	//readNoserializable("F:/JavaIO/noserializable.txt");
    }
    
    public static void read(String srcPath) throws FileNotFoundException, IOException, ClassNotFoundException{
    	File file = new File(srcPath);
    	ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
        Object object = objectInputStream.readObject();
        if(object instanceof Employee){
        	Employee employee = (Employee) object;
        	//这里那么回为空，因为name属性被transient修饰之后就不会再被序列化
        	System.out.println(employee.getName());
        	System.out.println(employee.getSalary());
        }
        object = objectInputStream.readObject();
        int[] arr= (int[])object;
        System.out.println(Arrays.toString(arr));
        objectInputStream.close();
    }
    /**
     * 
     * 描述：
     * @author gt
     * @created 2016年3月31日 上午12:58:54
     * @since 
     * @param strPath:序列化地址
     * @throws IOException
     */
    public static void write(String destPath) throws IOException{
    	File file = new File(destPath);
    	int[] arr = {2,1,3,5};
		ObjectOutputStream ObjectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
	    ObjectOutputStream.writeObject(new Employee("gutao", 2000.00));
	    ObjectOutputStream.writeObject(arr);
	    ObjectOutputStream.flush();
	    ObjectOutputStream.close();
    }
    public static void writeNoSerializable(String destPath) throws IOException{
    	File file = new File(destPath);
		ObjectOutputStream ObjectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
	    ObjectOutputStream.writeObject(new NoSerializable("gutao", "x"));
	    ObjectOutputStream.flush();
	    ObjectOutputStream.close();
    }
    
    public static void readNoserializable(String srcPath) throws FileNotFoundException, IOException, ClassNotFoundException{
    	File file = new File(srcPath);
    	ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
        Object object = objectInputStream.readObject();
        if(object instanceof NoSerializable){
        	NoSerializable no = (NoSerializable) object;
        	//这里那name为空，因为name属性被transient修饰之后就不会再被序列化
        	System.out.println(no.getName());
        	System.out.println(no.getAddress());
        }
        objectInputStream.close();
    }
}
