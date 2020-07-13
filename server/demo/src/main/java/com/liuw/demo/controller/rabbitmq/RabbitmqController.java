package com.liuw.demo.controller.rabbitmq;

import com.liuw.demo.rabbitmq.Producer;
import com.liuw.demo.rabbitmq.TopicSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuw
 * @date 2020-05-28 23:36
 */
@RestController
public class RabbitmqController {

    @Autowired
    private Producer producer;

    @Autowired
    private TopicSender topicSender;

    @GetMapping(value = "/send/string")
    public void sendString() {
        producer.sendString();
    }

    @GetMapping(value = "/send/object")
    public void sendObject() {
        producer.sendObject();
    }

    @GetMapping(value = "/send/topic")
    public void sendTopic() {
        topicSender.send1();
        topicSender.send2();
        topicSender.send3();
    }
}
