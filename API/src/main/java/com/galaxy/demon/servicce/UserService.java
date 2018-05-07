package com.galaxy.demon.servicce;

import com.galaxy.demon.dao.UserDao;
import com.galaxy.demon.entity.Org;
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

    public Org getOrg(int id){
        return userDao.getOrg(id);
    }
}
