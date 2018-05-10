package com.galaxy.demon.consumer;

import com.galaxy.demon.entity.Org;
import com.galaxy.demon.service.DemonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ApplicationConsumer {
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationConsumer.xml");
        ((ClassPathXmlApplicationContext) applicationContext).start();
        DemonService demonService = (DemonService) applicationContext.getBean("demonService");
        Org org = demonService.getOrg(1);
        if (null != org) {
            System.out.println(org.toString());
        }
    }
}
