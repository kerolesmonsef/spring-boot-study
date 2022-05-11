package com.example.demospringint.models;

import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "users")
@RestResource(rel="user", path="user") // default is users
public class User {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;
}
