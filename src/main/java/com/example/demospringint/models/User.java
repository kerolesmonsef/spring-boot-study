package com.example.demospringint.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;


@Data
@Entity
@Table(name = "users")
@RestResource(rel="user", path="user") // default is users
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(name = "name")
    @NotBlank
    @Size(min = 2, message = "name must be greater then 2 char keroles")
    private String name;


    @OneToMany(mappedBy = "user")
    private List<Book> books;

}
