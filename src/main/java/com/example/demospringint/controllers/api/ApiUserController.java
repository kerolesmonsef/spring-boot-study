package com.example.demospringint.controllers.api;

import com.example.demospringint.models.Test;
import com.example.demospringint.models.User;
import com.example.demospringint.repositories.jpa.intefaces.IJpaUserRepository;
import com.example.demospringint.resources.UserResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/api/users", produces = "application/json")
@CrossOrigin(origins = "*")
public class ApiUserController {
    IJpaUserRepository userRepository;

    public ApiUserController(IJpaUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/{id}")
    public ResponseEntity show(@PathVariable("id") Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            return new ResponseEntity<>((User) null, HttpStatus.OK);
        }
        return new ResponseEntity<>(user.get(), HttpStatus.NOT_FOUND);
    }

    @PostMapping("")
    public User store(@RequestBody @Valid User user) {
        return userRepository.save(user);
    }

    @GetMapping("")
    public List<User> users() {
        Pageable pageable = PageRequest.of(1, 1);

        return userRepository.findAll(pageable).toList();
    }



    @PutMapping("/{id}")
    public User update(@PathVariable("id") Long id, @RequestBody @Valid User user) {
        userRepository.save(user);
        return user; // TODO: return updated user

    }
}
