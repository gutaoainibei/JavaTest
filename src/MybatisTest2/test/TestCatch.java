package MybatisTest2.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import mybatisTest.GetSession;
import mybatisTest.User;

public class TestCatch {
  /*
   * 测试一级缓存
   * */
	@Test
  public void testCatch1(){
	  SqlSession session = GetSession.getSqlSession();
	  String statement = "mybatisTest.userMapper.getUser";
	  User user = session.selectOne(statement, 1);
	  System.out.println(user);
	  /*
	   * 默认有一级缓存
	   * */
	  User u = new User();
	  u.setId(1);
	  u.setAge(10);
	  u.setName("罗明");
	  int count = session.update("mybatisTest.userMapper"+".updateUser", u);
	  System.out.println("gengai:"+count);
	  User user2 = session.selectOne(statement,1);
	  System.out.println(user2);
	  
  }
	@Test
	  public void testCatch2(){
		  SqlSession session1 = GetSession.getSqlSession();
		  SqlSession session2 = GetSession.getSqlSession();
		  String statement = "mybatisTest.userMapper.getUser";
		  User user1 = session1.selectOne(statement, 1);
		  session1.commit();
		  System.out.println(user1);
		  User user2 = session2.selectOne(statement, 1);
		  session2.commit();
		  System.out.println(user2);
		  
		  
	  }
}
