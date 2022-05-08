package com.example.demospringint.repositories.jpa.intefaces;

import com.example.demospringint.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IJpaOrderRepository extends JpaRepository<Order, Long> {

}
