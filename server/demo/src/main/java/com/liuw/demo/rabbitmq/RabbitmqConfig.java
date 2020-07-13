package com.liuw.demo.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    @Bean
    public Queue stringQueue() {
        return new Queue("string.queue");
    }

    @Bean
    public Queue objectQueue() {
        return new Queue("object.queue");
    }
}
