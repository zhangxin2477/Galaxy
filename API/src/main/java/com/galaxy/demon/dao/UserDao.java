package com.galaxy.demon.dao;

import com.galaxy.demon.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {
    @Insert("insert into user(name,age) values(#{name},#{age})")
    @Options(useGeneratedKeys = true,keyColumn = "id")
    public int add(User user);
    @Update("update user set name=#{name},age=#{age} where id=#{id}")
    @Options(useGeneratedKeys = true,keyColumn = "id")
    public int update(User user);
    @Delete("delete from user where id=#{id}")
    public int delete(int id);
    @Select("select user.*,oragn from user where id=#{id}")
    public User getUser(int id);
    @Select("select * from user")
    public List<User> getUserList();
}
