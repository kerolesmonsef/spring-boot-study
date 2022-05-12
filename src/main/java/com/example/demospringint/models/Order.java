package com.example.demospringint.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue()
    private Long id;

    @NotBlank(message = "Name is required")
    private String name = "keroles";

    @NotBlank(message = "Street is required")
    private String street = "street shit";

    @NotBlank(message = "City is required")
    private String city = "city name";

    @NotBlank(message = "State is required")
    private String state = "state";

    @NotBlank(message = "Zip code is required")
    private String zip = "1234";

    private String ccNumber = "1234-5678-9012-1234";

    private String ccExpiration = "12-28";

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV = "123";

    private Date placedAt;

    @ManyToMany(targetEntity=Taco.class)
    private List<Taco> tacos = new ArrayList<Taco>();

    public void addDesign(Taco design) {
        this.tacos.add(design);
    }

    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }

}
