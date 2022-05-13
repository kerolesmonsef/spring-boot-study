package com.example.demospringint.resources;

import com.example.demospringint.controllers.UserController;
import com.example.demospringint.controllers.api.ApiUserController;
import com.example.demospringint.models.User;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class UserResourceAssembler extends RepresentationModelAssemblerSupport<User, UserResource> {
    public UserResourceAssembler() {
        super(ApiUserController.class, UserResource.class);
    }

    @Override
    protected UserResource instantiateModel(User user) {
        return new UserResource(user);
    }

    @Override
    public UserResource toModel(User user) {
        return createModelWithId(user.getId(), user);
    }


}
