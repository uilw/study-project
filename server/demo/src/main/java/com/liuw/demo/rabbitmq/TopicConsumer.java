package com.liuw.demo.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicConsumer {

    /**
     * 消费 String
     * @param message
     */
    @RabbitListener(queues = "topic.message.1")
    @RabbitHandler
    public void processMessage1(String message) {
        System.out.println("Topic message 1: " + message);
    }

    /**
     * 消费 Object
     * @param message
     */
    @RabbitListener(queues = "topic.message.2")
    @RabbitHandler
    public void processMessage2(String message) {
        System.out.println("Topic message 2: " + message);
    }
}
