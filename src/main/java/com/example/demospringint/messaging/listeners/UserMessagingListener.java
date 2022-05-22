package com.example.demospringint.messaging.listeners;

import com.example.demospringint.models.User;

public interface UserMessagingListener {
    void listenAndReceive(User user);
}
