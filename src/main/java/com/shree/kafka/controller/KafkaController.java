package com.shree.kafka.controller;

import com.shree.kafka.dto.User;
import com.shree.kafka.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class KafkaController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("/publish")
    public void publishMessage(){
        producerService.sendMessage(new User(1L, "Shree","9940409540","rsshreenaath@gmail.com","MMC"));
    }
}
