package com.zhangxin.demon.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sender(String topic,  String key, String value){
        kafkaTemplate.send(topic,key,value);
    }
}
