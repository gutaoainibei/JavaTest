package designPattern.Prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class TestSerizable {
   public static void main(String[] args) throws IOException, ClassNotFoundException {
	    Date date = new Date(124255654L);
		Sheep1 s1 =new Sheep1("gutao",date);
		System.out.println(s1.getName());
		System.out.println(s1.getBirthday());
		//通过序列化和反序列化实现深度克隆
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOut = new ObjectOutputStream(outputStream);
		objectOut.writeObject(s1);
		//反序列化
		byte[] arr = outputStream.toByteArray();
		ByteArrayInputStream inputStream = new ByteArrayInputStream(arr);
		ObjectInputStream objinput = new ObjectInputStream(inputStream);
		Sheep1 s2 = (Sheep1) objinput.readObject();
		date.setTime(232343566L);
		System.out.println(s1.getBirthday());
		s2.setName("nibei");
		System.out.println(s2.getName());
		System.out.println(s2.getBirthday());
}
}
