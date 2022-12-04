package com.shree.kafka.service;

import com.shree.kafka.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    @Value("${spring.kafka.producer.topic}")
    private String topic;

    public void sendMessage(User message) {
        CompletableFuture<SendResult<String, User>> future = this.kafkaTemplate.send(topic, message);
        future.handle((msg,exception)->exception != null? "Exception occurred": msg);
        future.whenComplete((msg,exception)->{
           if(exception != null) {
               log.error("Exception occurred when compling");
           } else {
               log.debug("Message Produced: {}", message);
           }
        });
    }

}
