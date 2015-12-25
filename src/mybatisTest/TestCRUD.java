package mybatisTest;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import mybatisTest.mapper.UserMapper;

/*
 * 测试mybatis的增删改查
 * */
public class TestCRUD {	
	/*
     * 配置文件方式来进行查询表中id为1的数据
     * */
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
   /*
    * 配置文件方式来进行更新表中id为1的数据
    * */
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
    /*
     * 配置文件方式来进行删除表中id为4的数据
     * */
    @Test
    public void deleteTest(){
 	    SqlSession session = GetSession.getSqlSession();
 	    String statement = "mybatisTest.userMapper"+".deleteUser";
 	  
 	    int i = session.delete(statement, 4);
 	    System.out.println("删除了 " + i + "记录");
    }
    /*
     * 配置文件方式来进行查询表中所有数据
     * */
    @Test
    public void getAllTest(){
 	    SqlSession session = GetSession.getSqlSession();
 	    String statement = "mybatisTest.userMapper"+".getAllUser";
 	  
 	    List<User> users= session.selectList(statement);
 	    System.out.println(users);
    }
    /*
     * 注解形式查询id号为1的User对象
     * */
    @Test
    public void AnnotationSelectTest(){
    	SqlSession session = GetSession.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.getUser(1);
        System.out.println("注解获得："+user);
    }
    /**
     * 注解形式来执行查询表中所有数据
     * */
    @Test
    public void AnnotationGetAllTest(){
    	SqlSession session = GetSession.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> user = userMapper.getAllUser();
        System.out.println("注解获得："+user);
    }
   
}
