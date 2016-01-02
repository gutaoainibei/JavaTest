package Exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
* @ClassName: TestException1 
* @Description: TODO(测试Exception Class) 
* @author gutao 
* @date 2016年1月2日 下午10:16:32 
*
 */
public class TestException1 {
	//异常执行的过程，首先执行try括号里面的，遇到异常后执行对应的catch里面的
	//catch和对应的异常的顺序不能错位，然后执行finnaly，最后执行返回的值
    public String TestExce(){
    	try {
  			FileReader fileReader = new FileReader("D:/Test.java");
  			char str = (char)fileReader.read();
  			System.out.println("step1");
  			return "step1 return";
  		} catch (FileNotFoundException e) {
  			System.out.println("step2");
  			e.printStackTrace();
  			return "step2 return";
  			
  		} catch (IOException e) {
  			System.out.println("step3");
  			e.printStackTrace();
  			return "step3 return";
  		}finally {
  			System.out.println("finanlly");
  		}
    	
    }
	public static void main(String[] args) {
        TestException1 testException1 = new TestException1();
        String str = testException1.TestExce();
        System.out.println(str);
	}

}
