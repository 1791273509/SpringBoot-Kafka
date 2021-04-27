package com.xwb;

import com.xwb.common.util.ToolsUtil;
import com.xwb.common.message.PayMessage;
import com.xwb.producer.MessageProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(KafkaApplication.class, args);
        MessageProducer producer = applicationContext.getBean(MessageProducer.class);
        while (true){
            PayMessage message = new PayMessage();
            message.setFee(ToolsUtil.getFee());
            message.setOrderCode(ToolsUtil.getNextCode());
            message.setSendTime(System.currentTimeMillis());
            producer.send(message);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
