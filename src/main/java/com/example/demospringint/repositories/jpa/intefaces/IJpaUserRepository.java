package com.example.demospringint.repositories.jpa.intefaces;

import com.example.demospringint.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IJpaUserRepository extends JpaRepository<User, Long> {
}
