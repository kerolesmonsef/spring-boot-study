package com.example.demospringint.repositories.jpa.intefaces;

import com.example.demospringint.models.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IJpaIngredientRepository extends CrudRepository<Ingredient, String> {

}
