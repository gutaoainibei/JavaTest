package SymmetryEncryption;

/**
 * 
 * 描述：加密工具类,暂时先放着，过段时间过来实现
 * @author gt
 * @created 2016年3月12日 下午1:52:50
 * @since
 */
public class EncryptUtils {
   public static void main(String[] args) {
        	 String string = "abcd1";
        	 System.out.println(spilitEncrypt(string));
             
   }
  public static String spilitEncrypt(String needEncryptString){
	  StringBuffer stringBuffer = new StringBuffer();
	  for (int i = needEncryptString.length()-1 ; i >= 0; i--) {
		    stringBuffer.append(needEncryptString.charAt(i));
	  }
	  
	  return stringBuffer.toString();
  }
}
