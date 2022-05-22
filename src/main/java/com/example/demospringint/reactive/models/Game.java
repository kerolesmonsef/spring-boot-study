package com.example.demospringint.reactive.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Game {
    private String name;
    private float price;
    private int storage;
}
