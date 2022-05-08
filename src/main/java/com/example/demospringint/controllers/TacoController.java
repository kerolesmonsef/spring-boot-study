package com.example.demospringint.controllers;

import com.example.demospringint.models.Ingredient;
import com.example.demospringint.models.Taco;
import com.example.demospringint.models.Test;
import com.example.demospringint.repositories.jdbc.interfaces.IngredientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/design")
@ControllerAdvice
public class TacoController {

    private final IngredientRepository ingredientRepo;

    @Autowired
    public TacoController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }


    @GetMapping
    public String showDesignForm(Model model, @ModelAttribute("em") Test test) {

        model.addAttribute("design", new Taco());
        return "design";
    }


    @PostMapping
    public String processDesign(@ModelAttribute("design") @Valid Taco design, BindingResult bindingResult) {

//        log.info(design.getIngredients().toString());
        if (bindingResult.hasErrors()) {
            return "design";
        }

        return "redirect:/orders/current";
    }


    @ModelAttribute
    public void getDesignIngredients(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.all().forEach(ingredients::add);


        Ingredient.Type[] types = Ingredient.Type.values();

        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), Ingredient.filterByType(ingredients, type));
        }
    }
}
