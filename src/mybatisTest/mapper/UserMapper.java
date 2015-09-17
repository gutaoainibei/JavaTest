package mybatisTest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import mybatisTest.User;

public interface UserMapper {
	@Select("select *from user where id = #{id}")
	public User getUser(int id);
	@Insert("insert into user(name,age) values(#{name},#{age})")
	public int addUser(User user);
    @Delete("delete from user where id = #{id}")
	public int deleteUser(int id);
    @Update("update user set name = #{name},age = #{age} where id = #{id}")
	public int updateUser(User user);
	@Select("select * from user")
	public List<User> getAllUser();
}
