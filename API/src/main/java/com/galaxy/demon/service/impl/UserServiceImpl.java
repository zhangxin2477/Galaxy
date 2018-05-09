package com.galaxy.demon.service.impl;

import com.galaxy.demon.dao.UserDao;
import com.galaxy.demon.entity.Org;
import com.galaxy.demon.service.DemonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements DemonService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired(required = false)
    private UserDao userDao;

    @Override
    public Org getOrg(int id){
        return userDao.getOrg(id);
    }
}
