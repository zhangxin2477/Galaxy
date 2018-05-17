package com.zhangxin.demon;

import com.zhangxin.demon.entity.Org;
import com.zhangxin.demon.producer.KafkaProducerService;
import com.zhangxin.demon.service.DemonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Scanner;

public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
        ((ClassPathXmlApplicationContext) context).start();
        log.info("服务已启动...");
        DemonService demonService = context.getBean(DemonService.class);
        Org org = demonService.getOrg(1);
        if (null != org) {
            log.info(org.toString());
        }

        KafkaProducerService kafkaProducer = context.getBean(KafkaProducerService.class);
        kafkaProducer.sender("my-topic","1","welcome");

        Scanner scan = new Scanner(System.in);
        while (true){
            String s=scan.nextLine();
            switch (s){
                case "exit":
                    return;
                case "go":
                    kafkaProducer.sender("my-topic",s,s);
                    break;
            }
        }
    }
}
