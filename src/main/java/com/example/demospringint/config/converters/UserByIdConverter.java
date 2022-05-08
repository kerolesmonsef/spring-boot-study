package com.example.demospringint.config.converters;

import com.example.demospringint.models.User;
import com.example.demospringint.repositories.jdbc.interfaces.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
public class UserByIdConverter implements Converter<String, User> {

    UserRepository userRepository;

    @Autowired
    UserByIdConverter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User convert(String id) {
        // get user from database
        User user = this.userRepository.find(id);
        // that is because it is throws an exception
        return Objects.requireNonNullElseGet(user, () -> new User());
    }
}
