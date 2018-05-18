package com.zhangxin.demon;

import com.zhangxin.demon.entity.Org;
import com.zhangxin.demon.entity.User;
import com.zhangxin.demon.service.DemonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Scanner;

public class ApplicationClient {
    private static final Logger log = LoggerFactory.getLogger(ApplicationClient.class);
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring_config.xml");
        ((ClassPathXmlApplicationContext) applicationContext).start();
        DemonService demonService = applicationContext.getBean(DemonService.class);
        log.info("客户端启动...");
        Scanner scan = new Scanner(System.in);
        boolean isRunning=true;
        do{
            String s=scan.nextLine();
            switch (s){
                case "org":
                    Org org = demonService.getOrg(1);
                    if (null != org) {
                        log.info(org.toString());
                    }
                    break;
                case "user":
                    User user=demonService.getUser(6);
                    if (null!=user){
                        log.info(user.toString());
                    }
                    break;
                case "kafka":
                    demonService = applicationContext.getBean(DemonService.class);
                    demonService.sender("my-topic","2","zhangxin");
                    break;
                case "quit":
                    isRunning=false;
                    break;
            }
        }while (isRunning);
        ((ClassPathXmlApplicationContext) applicationContext).stop();
        log.info("Bye!");
    }
}
