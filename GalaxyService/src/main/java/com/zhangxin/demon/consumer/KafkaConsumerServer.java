package com.zhangxin.demon.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.MessageListener;

public class KafkaConsumerServer implements MessageListener<String,String> {
    private static Logger logger=LoggerFactory.getLogger(KafkaConsumerServer.class);
    @Override
    public void onMessage(ConsumerRecord<String, String> record) {
        logger.info("KafkaConsumerServer=============kafkaConsumer开始消费=============");
        String topic = record.topic();
        String key = (String) record.key();
        String value = (String) record.value();
        long offset = record.offset();
        int partition = record.partition();
        logger.info("KafkaConsumerServer-------------topic:"+topic);
        logger.info("KafkaConsumerServer-------------value:"+value);
        logger.info("KafkaConsumerServer-------------key:"+key);
        logger.info("KafkaConsumerServer-------------offset:"+offset);
        logger.info("KafkaConsumerServer-------------partition:"+partition);
        logger.info("~~~~~~~~~~~~~kafkaConsumer消费结束~~~~~~~~~~~~~");
        System.out.println("消费成功***************************************************************");
    }
}