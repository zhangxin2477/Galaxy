package com.zhangxin.demon;

import com.zhangxin.demon.entity.Org;
import com.zhangxin.demon.service.DemonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ApplicationConsumer {
    private static final Logger log = LoggerFactory.getLogger(ApplicationConsumer.class);
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring_config.xml");
        ((ClassPathXmlApplicationContext) applicationContext).start();
        DemonService demonService = (DemonService) applicationContext.getBean("demonService");
        Org org = demonService.getOrg(1);
        if (null != org) {
            log.info(org.toString());
        }
    }
}
