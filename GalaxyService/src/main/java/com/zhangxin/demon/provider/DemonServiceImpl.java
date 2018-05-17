package com.zhangxin.demon.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.zhangxin.demon.dao.UserDao;
import com.zhangxin.demon.entity.Org;
import com.zhangxin.demon.service.DemonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0",interfaceClass = DemonService.class,timeout = 10000)
public class DemonServiceImpl implements DemonService {
    private static final Logger log = LoggerFactory.getLogger(DemonServiceImpl.class);

    @Autowired(required = false)
    private UserDao userDao;

    @Override
    public Org getOrg(int id) {
        return userDao.getOrg(id);
    }
}
