package com.example.demospringint.resources;

import com.example.demospringint.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@RequiredArgsConstructor
public class UserResource extends RepresentationModel<UserResource> {
    private String name;
    private Long id;


    public UserResource(User user) {
        this.name = user.getName();
        this.id = user.getId();
    }
}
