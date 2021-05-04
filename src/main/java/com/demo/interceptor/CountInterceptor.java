package com.demo.interceptor;

import java.util.Map;
import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

/**
 * @author wenbaox
 * @version 1.0
 * @date 2021/5/4 下午4:39
 */
public class CountInterceptor implements ProducerInterceptor {
    int success = 0;
    int error = 0;


    @Override
    public ProducerRecord onSend(ProducerRecord producerRecord) {
        return producerRecord;
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {
        if(e != null) {
           error ++;
        } else {
            success ++;
        }
    }

    @Override
    public void close() {
        System.out.println("success" + success);
        System.out.println("error" + error);

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
    