package com.example.demospringint.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
@Entity
@Table(name = "users")
@RestResource(rel="user", path="user") // default is users
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name")
    @NotBlank
    @Size(min = 2, message = "name must be greater then 2 char keroles")
    private String name;
}
