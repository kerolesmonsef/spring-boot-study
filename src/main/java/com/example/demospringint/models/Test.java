package com.example.demospringint.models;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Test {

    @NotNull
    @Size(min = 5)
    String name;

}
