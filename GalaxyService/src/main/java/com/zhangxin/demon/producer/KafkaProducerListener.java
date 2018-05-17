package com.zhangxin.demon.producer;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.ProducerListener;

public class KafkaProducerListener implements ProducerListener {
    protected final Logger log = LoggerFactory.getLogger(KafkaProducerListener.class);

    @Override
    public void onSuccess(String topic, Integer partition, Object key, Object value, RecordMetadata recordMetadata) {
        log.info("==========kafka发送数据成功（日志开始）==========");
        log.info("----------topic:" + topic + "，partition:" + partition + "，key:" + key + "，value:" + value + "，RecordMetadata:" + recordMetadata);
        log.info("~~~~~~~~~~kafka发送数据成功（日志结束）~~~~~~~~~~");
    }

    @Override
    public void onError(String topic, Integer partition, Object key, Object value, Exception exception) {
        log.info("==========kafka发送数据错误（日志开始）==========");
        log.info("----------topic:" + topic + "，partition:" + partition + "，key:" + key + "，value:" + value + "，Exception:" + exception);
        log.info("~~~~~~~~~~kafka发送数据错误（日志结束）~~~~~~~~~~");
        exception.printStackTrace();
    }

    @Override
    public boolean isInterestedInSuccess() {
        log.info("==========kafka监听器启动==========");
        return true;
    }
}
