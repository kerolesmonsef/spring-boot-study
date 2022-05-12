package com.example.demospringint.repositories.jdbc;

import com.example.demospringint.models.User;
import com.example.demospringint.repositories.jdbc.interfaces.UserRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcUserRepository implements UserRepository {

    private final JdbcTemplate jdbc;

    public JdbcUserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public User find(String id) {
        try {
            return jdbc.queryForObject(
                    "select id, name from users where id=?",
                    new BeanPropertyRowMapper<>(User.class), id);

        } catch (Exception e) {
            System.out.println("catch" + e.getMessage());
            return null;
        }

    }
}
