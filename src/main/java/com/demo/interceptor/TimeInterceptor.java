package com.demo.interceptor;

import java.util.Date;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

/**
 * @author wenbaox
 * @version 1.0
 * @date 2021/5/4 下午4:33
 */
public class TimeInterceptor implements ProducerInterceptor<String,String> {

    //在前面加个时间戳
    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> producerRecord) {
        // 1、取出数据
        String value = producerRecord.value();
        value += new Date();
        //2、重新设置
        ProducerRecord producerRecord1 = new ProducerRecord<>(producerRecord.topic(), producerRecord.partition(),
                producerRecord.key(), value);

        return producerRecord1;
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {

    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
    