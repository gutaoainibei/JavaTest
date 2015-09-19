package MybatisTest2.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import MybatisTest2.base.GetSession;
import MybatisTest2.model.Classes;
import MybatisTest2.model.Puser;
import MybatisTest2.model.SelePuser;

public class TestOnetoOneOrMore {
  @Test
  public void TestGetOne(){
	  SqlSession session = GetSession.getSqlSession();
	  String statement = "MybatisTest2.ClassesMapper.getone";
	  Classes classes = session.selectOne(statement, 1);
	  System.out.println("获得结果1:"+classes);
	  session.close();
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
	  session.close();
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
	  session.close();
  }
  @Test
  public void TestGetAllInfo(){
	  SqlSession session = GetSession.getSqlSession();
	  String statement = "MybatisTest2.ClassesMapper.getAllInfo";
	  List<Classes> classes = session.selectList(statement);
	  System.out.println("获得结果1:"+classes);
	  session.close();
  }
  /*
   * 
   * */
  @Test
  public void TestDeleteStudent(){
	  SqlSession session = GetSession.getSqlSession();
	  String statement = "MybatisTest2.ClassesMapper.deleteStudent";
	  int  i= session.delete(statement,1);
	  System.out.println("获得结果1:"+i);
	  session.close();
  }
  /*
   * 下面这个方法是错的
   * 因为不能
   * org.apache.ibatis.exceptions.PersistenceException: 
     Cannot delete or update a parent row: a foreign key constraint 
     fails (`test/student`, CONSTRAINT `fros_id` FOREIGN KEY (`cid`) REFERENCES `class` (`cid`))
   * */
  @Test
  public void TestDeleteClass(){
	  SqlSession session = GetSession.getSqlSession();
	  String statement = "MybatisTest2.ClassesMapper.deleteClasses";
	  int  i= session.delete(statement,1);
	  System.out.println("获得结果1:"+i);
	  session.close();
  }
  /*
   * map传值获取age在18到19的用户
   * 对应*mapper.xml中的parameterType可以是hashmap或者map
   * */
  @Test
  public void TestgetPuser(){
	  SqlSession session = GetSession.getSqlSession();
	  String statement = "MybatisTest2.PuserMapper.getPuser";
	  Map<String, Integer> map = new HashMap<String, Integer>();
	  map.put("minage", 18);
	  map.put("maxage", 19);
	  List<Puser> list= session.selectList(statement,map);
	  System.out.println("获得结果1:"+list);
	  session.close();
  }
  /*
   * 模糊查询
   * */
  @Test
  public void TestSelectPuser(){
	  SqlSession session = GetSession.getSqlSession();
	  String statement = "MybatisTest2.PuserMapper.getSelectPuser";
	  String name = "nibei";
	  //name = null; 
	  Map<String, Object> map = new HashMap<String, Object>();
	  map.put("minage", 18);
	  map.put("maxage", 19);
	  map.put("name", "%"+name+"%");
//	  SelePuser selePuser = new SelePuser("%"+name+"%",18,19);
	  List<Puser> list= session.selectList(statement,map);
	  System.out.println("获得结果1:"+list);
	  session.close();
  }

  @Test
  public void TestProcedure(){
	  SqlSession session = GetSession.getSqlSession();
	  String statement = "MybatisTest2.PuserMapper.getCount1";
	  Map<String, Object> map = new HashMap<String, Object>();
	  map.put("sexid", 0);
	  map.put("usercount", -1);
	  session.selectOne(statement,map);
	  System.out.println("获得人数:"+map.get("usercount"));
	  session.close();
  }
}
