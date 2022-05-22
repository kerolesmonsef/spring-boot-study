package com.example.demospringint.messaging.types.jms;

import com.example.demospringint.messaging.receivers.UserMessagingReceiver;
import com.example.demospringint.models.User;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsUserMessagingReceiver implements UserMessagingReceiver {
    private final JmsTemplate template;

    public JmsUserMessagingReceiver(JmsTemplate template) {
        this.template = template;
    }

    public User receive() {
        return (User) template.receiveAndConvert("user"); // this will block the main thread
    }
}
