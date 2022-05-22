package com.example.demospringint.controllers;

import com.example.demospringint.models.User;
import com.example.demospringint.repositories.jpa.intefaces.JpaUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    Environment env;
    JpaUserRepository userRepository;

    public UserController(Environment env, JpaUserRepository userRepository) {
        this.env = env;
        this.userRepository = userRepository;
    }


    @GetMapping
    public String index(RedirectAttributes redirect, Model model) {
        model.addAttribute("user", "shit");
        return "redirect:/user/1"; // this will redirect to http://localhost:8080/user/1?success_message=
    }

    @ResponseBody
    @GetMapping("/test")
    public ResponseEntity test() {
        Map<String, Object> response = new HashMap();
        response.put("status", "success");
        response.put("user", new User()); // user from database
        response.put("users", userRepository.findAll());
        return ResponseEntity.ok(response);
    }


    @ResponseBody
    @GetMapping("/{id}")
    public User show(@PathVariable("id") Optional<User> user, @ModelAttribute("user") String userString) {
        System.out.println(userString);
        return user.orElse(null);
    }

    @ResponseBody
    @GetMapping("/jpa/all")
    public Iterable<User> all(@RequestParam("page") Optional<Integer> page) {

        Pageable pageable = PageRequest.of(page.orElse(1), 1);

        return userRepository.findAll(pageable);
    }

    // update user


}

