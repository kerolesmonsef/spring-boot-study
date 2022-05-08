package com.example.demospringint.repositories.jdbc.interfaces;

import com.example.demospringint.models.Order;

public interface OrderRepository {
    Iterable<Order> all();

    Order save(Order order);
}
