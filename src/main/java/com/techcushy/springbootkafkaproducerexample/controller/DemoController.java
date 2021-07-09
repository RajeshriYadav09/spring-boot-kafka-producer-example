package com.techcushy.springbootkafkaproducerexample.controller;

import com.techcushy.springbootkafkaproducerexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    @Autowired
    KafkaTemplate<String, User> stringUserKafkaTemplate;

    private static final String NewTopic = "NewTopic";


   @PostMapping("/publishUser")
    public String publishMessage(@RequestBody User user){
        stringUserKafkaTemplate.send(NewTopic, user);
        return "published Successfully";
    }
}
