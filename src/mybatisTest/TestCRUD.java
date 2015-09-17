package mybatisTest;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestCRUD {
   @org.junit.Test
   public void addTest(){
	    SqlSession session = GetSession.getSqlSession();
	    String statement = "mybatisTest.userMapper"+".addUser";
	    User user = new User();
	    user.setId(-1);
	    user.setAge(20);
	    user.setName("罗明");
	    int i = session.insert(statement, user);
	    System.out.println("新增了 " + i + "记录");
   }
    @Test
   public void UpdateTest(){
	    SqlSession session = GetSession.getSqlSession();
	    String statement = "mybatisTest.userMapper"+".updateUser";
	    User user = new User();
	    user.setId(1);
	    user.setAge(100);
	    user.setName("罗明");
	    int i = session.update(statement, user);
	    System.out.println("更新了 " + i + "记录");
   }
    @Test
    public void deleteTest(){
 	    SqlSession session = GetSession.getSqlSession();
 	    String statement = "mybatisTest.userMapper"+".deleteUser";
 	  
 	    int i = session.delete(statement, 4);
 	    System.out.println("删除了 " + i + "记录");
    }
    @Test
    public void getAllTest(){
 	    SqlSession session = GetSession.getSqlSession();
 	    String statement = "mybatisTest.userMapper"+".getAllUser";
 	  
 	    List<User> users= session.selectList(statement);
 	    System.out.println(users);
    }
   
}
