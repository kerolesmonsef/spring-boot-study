package com.example.demospringint.controllers;

import com.example.demospringint.models.Book;
import com.example.demospringint.repositories.jdbc.JdbcBookRepository;
import com.example.demospringint.repositories.jpa.intefaces.JpaBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private JpaBookRepository bookRepository;

    @Autowired
    private JdbcBookRepository jdbcBookRepository;

    @GetMapping("/books")
    public Object index() {
        List<Integer> ids = Arrays.asList(1, 2, 4);

        List<Book> books = bookRepository.findBooksByIds(ids);

        System.out.println(books);

        bookRepository.findById(1111).orElseThrow();

        return ids;
    }

    @GetMapping("/books/hqlwherein")
    public Object hqlWhereIn() {
        return jdbcBookRepository.hqlfindbyids(Arrays.asList(1, 2, 4));
    }

    @GetMapping("/books/criteriawherein")
    public Object criteriawherein() {

        return jdbcBookRepository.criteriafindbyids(Arrays.asList(1, 2, 4));
    }

    @GetMapping("/books/leftJoinPaginate")
    public Object leftJoinPaginate() {
        Pageable pageable = PageRequest.of(1, 2).previousOrFirst();

        return bookRepository.userLeftJoinBook(pageable);
    }
}
