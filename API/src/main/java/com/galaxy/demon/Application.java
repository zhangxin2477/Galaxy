package com.galaxy.demon;

import com.galaxy.demon.entity.Org;
import com.galaxy.demon.entity.User;
import com.galaxy.demon.servicce.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean(UserService.class);

        Org org = userService.getOrg(1);
        if (null != org)
            log.info(org.toString());
    }
}
