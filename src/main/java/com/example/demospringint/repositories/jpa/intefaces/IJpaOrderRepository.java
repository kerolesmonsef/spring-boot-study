package com.example.demospringint.repositories.jpa.intefaces;

import com.example.demospringint.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface IJpaOrderRepository extends CrudRepository<Order, Long> {

}
