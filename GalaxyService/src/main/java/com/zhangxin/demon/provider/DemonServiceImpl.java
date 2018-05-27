package com.zhangxin.demon.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.zhangxin.demon.dao.UserDao;
import com.zhangxin.demon.entity.Org;
import com.zhangxin.demon.entity.User;
import com.zhangxin.demon.service.DemonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Service
@Component
public class DemonServiceImpl implements DemonService {
    private static final Logger log = LoggerFactory.getLogger(DemonServiceImpl.class);

    @Autowired
    private UserDao userDao;

    //@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public String hello(String say) {
        return say;
    }

    @Override
    public void sender(String topic, String key, String value) {
        kafkaTemplate.send(topic, key, value);
    }

    @Override
    public Org getOrg(int id) {
        log.info("数据库开始");
        Org org=userDao.getOrg(id);
        log.info("数据库结束");
        return org;
    }

    @Override
    public User getUser(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public User login(String name, String pw) {
        return userDao.getUserByNp(name, pw);
    }
}
