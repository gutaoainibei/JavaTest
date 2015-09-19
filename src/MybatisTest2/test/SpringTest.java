package MybatisTest2.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import MybatisTest2.dao.UserMapper;
import MybatisTest2.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-application.xml")
public class SpringTest {

	private UserMapper userMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Test
	public void test1() {
		User user = userMapper.findById(1);
		System.out.println(user);
	}
	@Test
	public void test2() {
		//	public void save(User user);
		User user =new User();
		user.setAge(22);
		user.setName("顾涛");
		userMapper.save(user);
	}
	/*删除测试
	 * */
	@Test
	public void test3() {
		//	public void save(User user);
	
		userMapper.delete(1);;
	}
	/*
	 * 更新测试
	 * */
	@Test
	public void test4() {
		//	public void save(User user);
		User user =new User();
		user.setId(2);
		user.setAge(20);
		user.setName("倪贝");
		userMapper.update(user);
	}
}
