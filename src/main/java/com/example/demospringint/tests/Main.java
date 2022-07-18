package com.example.demospringint.tests;

import com.example.demospringint.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        Map map = Map.ofEntries(
                Map.entry("name", "John"),
                Map.entry("id", 30)
        );
        User user = mapper.convertValue(map, User.class);
        System.out.println(user);


    }

}


