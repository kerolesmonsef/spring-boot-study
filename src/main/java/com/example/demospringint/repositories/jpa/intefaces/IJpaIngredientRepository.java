package com.example.demospringint.repositories.jpa.intefaces;

import com.example.demospringint.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJpaIngredientRepository extends JpaRepository<Ingredient, String> {

}
