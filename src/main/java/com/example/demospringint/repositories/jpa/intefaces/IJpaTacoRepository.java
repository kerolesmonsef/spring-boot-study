package com.example.demospringint.repositories.jpa.intefaces;

import com.example.demospringint.models.Taco;
import org.springframework.data.repository.CrudRepository;

public interface IJpaTacoRepository extends CrudRepository<Taco, Long> {
}
