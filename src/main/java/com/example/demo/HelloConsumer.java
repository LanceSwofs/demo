package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RabbitListener(queues = "hello")
public class HelloConsumer {

    @RabbitHandler
    public void onMessage(String messageStr) {
        log.warn("接收到发送的消息");
        System.out.println(messageStr);
    }

}