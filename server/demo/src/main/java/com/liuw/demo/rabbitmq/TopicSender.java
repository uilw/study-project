package com.liuw.demo.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send1() {
        amqpTemplate.convertAndSend("topicExchange","age.12", "age.12");
    }

    public void send2() {
        amqpTemplate.convertAndSend("topicExchange","mess.message", "mess.message");
    }

    public void send3() {
        amqpTemplate.convertAndSend("topicExchange","age.21", "age.21");
    }
}
