package com.galaxy.demon;

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
        int r = userService.delete(5);
        if(r>0){
            log.info("成功");
        }
        log.info(userService.getUserList().toString());
        User user = userService.get(5);
        if (null!=user) {
            log.info(user.toString());
        }
    }
}
