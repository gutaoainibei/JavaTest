package mybatisTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
       SqlSession session = GetSession.getSqlSession();
	   ////映射sql 的标识字符串前面是namespace后面是对应的id
	   String statement = "mybatisTest.userMapper"+".getUser";
	   //执行查询返回一个唯一user 对象的sql
	   User user = session.selectOne(statement,1);
	   
	   System.out.println(user);
	}

}
