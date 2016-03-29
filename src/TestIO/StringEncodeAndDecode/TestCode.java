package TestIO.StringEncodeAndDecode;

import java.io.UnsupportedEncodingException;



public class TestCode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "菩提本无树，明镜亦非台";
		byte[] b= str.getBytes();
		System.out.println(new String(b,"gbk"));//编码不一致，会导致乱码
		System.out.println(new String(b));//默认的编码：utf-8
		System.out.println(new String(b, 0, 10));//字节缺失，也会导致乱码
	}
}
