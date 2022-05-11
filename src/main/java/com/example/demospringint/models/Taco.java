package com.example.demospringint.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "name is null hahah")
    @Size(min = 5)
    private String name = "de n";

//    @NotNull
//    @Size(min = 1, message = "You must choose at least 1 ingredient")
//    @ManyToMany
//
//    private List<Ingredient> ingredients;

    private Date createdAt;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}
