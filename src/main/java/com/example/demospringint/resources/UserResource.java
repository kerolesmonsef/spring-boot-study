package com.example.demospringint.resources;

import com.example.demospringint.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserResource {
    private final User user;
    private String status = "success";
}
