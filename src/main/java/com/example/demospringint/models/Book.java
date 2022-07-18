package com.example.demospringint.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "books")
public class Book {
    @Id
    private int id;

    @Column(name = "b_publisher")
    private String publisher;

    @Column(name = "b_qty")
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
