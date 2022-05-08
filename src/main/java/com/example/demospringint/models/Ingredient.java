package com.example.demospringint.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

// this code will add getters and setters for class for free
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ingredient {
    @Id
    public String id;
    String name;
    Type type;
    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

    public static List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        List<Ingredient> newList = new ArrayList<>();

        for (Ingredient ingredient : ingredients) {
            if (ingredient.type == type) {
                newList.add(ingredient);
            }
        }
        return newList;
    }
}