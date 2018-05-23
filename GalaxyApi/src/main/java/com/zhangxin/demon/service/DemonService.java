package com.zhangxin.demon.service;

import com.zhangxin.demon.entity.Org;
import com.zhangxin.demon.entity.User;

public interface DemonService {
    String hello(String say);

    void sender(String topic, String key, String value);

    Org getOrg(int id);

    User getUser(int id);
}
