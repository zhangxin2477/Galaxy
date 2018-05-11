package com.zhangxin.demon.provider;

import com.zhangxin.demon.dao.UserDao;
import com.zhangxin.demon.entity.Org;
import com.zhangxin.demon.service.DemonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@com.alibaba.dubbo.config.annotation.Service(interfaceClass = DemonService.class)
@Component
public class UserServiceImpl implements DemonService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired(required = false)
    private UserDao userDao;

    @Override
    public Org getOrg(int id) {
        return userDao.getOrg(id);
    }
}
