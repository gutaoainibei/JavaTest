package MybatisTest2.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import MybatisTest2.base.GetSession;
import MybatisTest2.model.Classes;

public class TestOnetoOneOrMore {
  @Test
  public void TestGetOne(){
	  SqlSession session = GetSession.getSqlSession();
	  String statement = "MybatisTest2.ClassesMapper.getone";
	  Classes classes = session.selectOne(statement, 1);
	  System.out.println("获得结果1:"+classes);
  }
  /*
   * 联合查询，个人比较喜欢，效率高
   * */
  @Test
  public void TestGetAll(){
	  SqlSession session = GetSession.getSqlSession();
	  String statement = "MybatisTest2.ClassesMapper.getAll";
	  List<Classes> classes = session.selectList(statement);
	  System.out.println("获得结果集:"+classes);
  }
  /*
   * 用了连词sql语句，这种查询方式个人不建议用，消耗cpu还繁琐
   * */
  @Test
  public void TestGetOnel(){
	  SqlSession session = GetSession.getSqlSession();
	  String statement = "MybatisTest2.ClassesMapper.getClass2";
	  Classes classes = session.selectOne(statement, 1);
	  System.out.println("获得结果1:"+classes);
  }
}
