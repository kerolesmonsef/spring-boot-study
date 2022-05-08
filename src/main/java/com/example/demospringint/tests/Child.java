package com.example.demospringint.tests;

public class Child implements Parent {
    @Override
    public String getName() {
        return "keroles";
    }

    public String getShit(){
        return "shit";
    }
}
