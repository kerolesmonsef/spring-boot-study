package com.example.demospringint.repositories.jpa.intefaces;

import com.example.demospringint.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<User, Long> {
}
