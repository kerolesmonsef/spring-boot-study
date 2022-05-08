package com.example.demospringint.controllers;

import com.example.demospringint.models.Order;
import com.example.demospringint.repositories.jpa.intefaces.IJpaOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {


    IJpaOrderRepository orderRepository;

    @Autowired
    OrderController(IJpaOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    @ResponseBody
    @PostMapping("")
    public String processOrder(@Valid Order order) {
        log.info("order => " + order);
        return "redirect:/design";
    }


}
