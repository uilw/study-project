package com.liuw.demo.rabbitmq;

import com.liuw.demo.db.domain.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 生产 String
     */
    public void sendString() {
        for (int i = 0; i < 5; i++) {
            String message = "hi, string is " + i + " !";
            System.out.println("Producer: " + message);
            amqpTemplate.convertAndSend("string.queue", message);
        }
    }

    /**
     * 生产 Object
     */
    public void sendObject() {
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(Long.valueOf(i+""));
            amqpTemplate.convertAndSend("object.queue", user.toString());
        }
    }
}
