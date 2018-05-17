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

public class ApplicationServer {
    private static final Logger log = LoggerFactory.getLogger(ApplicationServer.class);

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
        ((ClassPathXmlApplicationContext) context).start();
        log.info("服务已启动...");

        Scanner scan = new Scanner(System.in);
        boolean isRunning=true;
        do{
            String s=scan.nextLine();
            switch (s){
                case "dubbo":
                    DemonService demonService = context.getBean(DemonService.class);
                    Org org = demonService.getOrg(1);
                    if (null != org) {
                        log.info(org.toString());
                    }
                    break;
                case "kafka":
                    KafkaProducerService kafkaProducer = context.getBean(KafkaProducerService.class);
                    kafkaProducer.sender("my-topic","1","welcome");
                    break;
                case "go":
                    kafkaProducer = context.getBean(KafkaProducerService.class);
                    kafkaProducer.sender("my-topic",s,s);
                    break;
                case "quit":
                    isRunning=false;
                    break;
            }
        }while (isRunning);
        ((ClassPathXmlApplicationContext) context).stop();
        log.info("Bye!");
    }
}
