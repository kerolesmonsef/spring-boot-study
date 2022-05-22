package com.example.demospringint.messaging.types.jms;

import com.example.demospringint.messaging.senders.UserMessagingSender;
import com.example.demospringint.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsUserMessagingSender implements UserMessagingSender {
    @Autowired
    JmsTemplate template;

    @Override
    public void send(User user) {
//        template.send("user", (session -> new MappingJackson2MessageConverter().toMessage(user, session)));
        template.convertAndSend("user", user);
    }
}
