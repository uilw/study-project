package com.liuw.demo.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitmqConfig {

    final static String message1 = "topic.message.1";
    final static String message2 = "topic.message.2";

    @Bean
    public Queue topicMessage1() {
        return new Queue(TopicRabbitmqConfig.message1);
    }

    @Bean
    public Queue topicMessage2() {
        return new Queue(TopicRabbitmqConfig.message2);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    Binding bindingExchangeMessage1(Queue topicMessage1, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicMessage1).to(topicExchange).with("age.#1");
    }

    @Bean
    Binding bindingExchangeMessage2(Queue topicMessage2, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicMessage2).to(topicExchange).with("mess.#");
    }
}
