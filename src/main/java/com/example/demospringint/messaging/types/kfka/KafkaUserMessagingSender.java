package com.example.demospringint.messaging.types.kfka;

import com.example.demospringint.messaging.senders.UserMessagingSender;
import com.example.demospringint.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaUserMessagingSender implements UserMessagingSender {

    private final KafkaTemplate<String, User> template;

    @Autowired
    public KafkaUserMessagingSender(KafkaTemplate<String, User> template) {
        this.template = template;
    }

    @Override
    public void send(User user) {
        this.template.sendDefault( user);
    }
}
