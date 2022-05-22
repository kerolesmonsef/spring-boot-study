package com.example.demospringint.controllers;

import com.example.demospringint.messaging.types.jms.JmsUserMessagingReceiver;
import com.example.demospringint.messaging.types.jms.JmsUserMessagingSender;
import com.example.demospringint.messaging.types.kfka.KafkaUserMessagingSender;
import com.example.demospringint.models.User;
import com.example.demospringint.repositories.jpa.intefaces.JpaUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/message")
public class MessageController {

    private final JpaUserRepository repository;
    private final JmsUserMessagingSender jmsSender;

    private final KafkaUserMessagingSender kafkaSender;

    @Autowired
    JmsUserMessagingReceiver userMessagingReceiver;

    public MessageController(JpaUserRepository repository, JmsUserMessagingSender messagingService, KafkaUserMessagingSender kafkaSender) {
        this.repository = repository;
        this.jmsSender = messagingService;
        this.kafkaSender = kafkaSender;
    }

    // jms send user
    @GetMapping("/jms_send")
    public Object jms_send() {
        User user = repository.findById(1L).get();
        jmsSender.send(user);
        return "done";
    }

    // jms receive user
    @GetMapping("/jms_receive")
    public Object jms_receive() {
        log.info("thead name {}", Thread.currentThread().getName());
        Object user = userMessagingReceiver.receive(); // will block the main thread
        return "user";
    }

   // kafka send user
    @GetMapping("/kafka_send")
    public Object kafka_send() {
        User user = repository.findById(1L).get();
        kafkaSender.send(user);
        return "done";
    }

    // kafka receive user
    @GetMapping("/kafka_receive")
    public Object kafka_receive() {
        log.info("thead name {}", Thread.currentThread().getName());
//        Object user = kafkaSender.receive(); // will block the main thread
        return "user";
    }
}
