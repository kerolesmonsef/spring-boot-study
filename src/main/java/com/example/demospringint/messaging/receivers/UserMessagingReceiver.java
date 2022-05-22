package com.example.demospringint.messaging.receivers;

import com.example.demospringint.models.User;

public interface UserMessagingReceiver {
    public User receive();
}
