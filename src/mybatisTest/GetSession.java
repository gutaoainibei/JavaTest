package mybatisTest;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GetSession {
   public static SqlSession getSqlSession(){
       String resource = "conf.xml";
//     //加载配置文件
//     Reader reader = Resources.getResourceAsReader(resource);
       InputStream reader =Test.class.getClassLoader().getResourceAsStream(resource);
	   //构建sqlsession的工厂
	   SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
	   //创建能执行映射文件中的sql的sqlsession,这里注意一个问题，opensession默认的是手动提交，所以要想自动提交要加上true
	   SqlSession session = sessionFactory.openSession(true);
	   return session;
   }
}
