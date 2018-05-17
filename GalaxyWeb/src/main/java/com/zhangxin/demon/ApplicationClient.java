package com.zhangxin.demon;

import com.zhangxin.demon.entity.Org;
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
        Scanner scan = new Scanner(System.in);
        boolean isRunning=true;
        do{
            String s=scan.nextLine();
            switch (s){
                case "dubbo":
                    DemonService demonService = applicationContext.getBean(DemonService.class);//demonServiceImpl
                    Org org = demonService.getOrg(1);
                    if (null != org) {
                        log.info(org.toString());
                    }
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
