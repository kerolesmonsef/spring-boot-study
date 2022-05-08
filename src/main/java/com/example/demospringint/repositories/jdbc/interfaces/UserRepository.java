package com.example.demospringint.repositories.jdbc.interfaces;

import com.example.demospringint.models.User;

public interface UserRepository {
    User find(String id);
}
