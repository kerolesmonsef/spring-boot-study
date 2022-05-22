package com.example.demospringint.messaging.senders;

import com.example.demospringint.models.User;

public interface UserMessagingSender {
    public void send(User user);
}
