package com.liuw.demo.rabbitmq;

import com.liuw.demo.db.domain.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    /**
     * 消费 String
     * @param string
     */
    @RabbitListener(queues = "string.queue")
    @RabbitHandler
    public void processString(String string) {
        System.out.println("Consumer-String-Queue: " + string);
    }

    /**
     * 消费 Object
     * @param object
     */
    @RabbitListener(queues = "object.queue")
    @RabbitHandler
    public void processObject(String object) {
        System.out.println("Consumer-Obejct-Queue: " + object);
    }
}
