package com.example.demospringint.repositories.jdbc.interfaces;

import com.example.demospringint.models.Ingredient;

public interface IngredientRepository {

    Iterable<Ingredient> all();

    Ingredient find(String id);

    Ingredient save(Ingredient ingredient);
}
