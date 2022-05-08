package com.example.demospringint.controllers;

import com.example.demospringint.models.User;
import com.example.demospringint.repositories.jpa.intefaces.IJpaUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
    IJpaUserRepository userRepository;

    @Autowired
    public UserController(IJpaUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String index(RedirectAttributes redirect, Model model) {
        model.addAttribute("user", "shit");
        return "redirect:/user/1"; // this will redirect to http://localhost:8080/user/1?success_message=
    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") User user, @ModelAttribute("user") String userString) {
        System.out.println(userString);
        return "home";
    }

    @ResponseBody
    @GetMapping("/jpa/all")
    public Iterable<User> all(@RequestParam("page") Optional<Integer> page) {


        Pageable pageable = PageRequest.of(page.orElse(1), 1);

        return userRepository.findAll(pageable);
    }
}

