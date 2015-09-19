package MybatisTest2.dao;

import java.util.List;

import MybatisTest2.model.User;

public interface UserMapper {
	public void save(User user);
	public void update(User user);
	public void delete(int id);
	public User findById(int id);
	public List<User> findAll();
}
