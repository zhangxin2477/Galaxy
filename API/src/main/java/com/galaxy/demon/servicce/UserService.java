package com.galaxy.demon.servicce;

import com.galaxy.demon.dao.UserDao;
import com.galaxy.demon.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired(required = false)
    private UserDao userDao;

    public int add(String name,int age,String school){
        User user=new User(name,age,school);
        int r = userDao.add(user);
        log.info(user.toString());
        return r;
    }

    public int update(int id,String name,int age,String school){
        User user=new User(id,name,age,school);
        int r=userDao.update(user);
        log.info(user.toString());
        return r;
    }

    public int delete(int id){
        int r=userDao.delete(id);
        return r;
    }

    public User get(int id) {
        User user=userDao.getUser(id);
        return user;
    }

    public List<User> getUserList(){
        return userDao.getUserList();
    }
}
