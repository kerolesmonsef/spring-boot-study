package com.example.demospringint.repositories.jpa.intefaces;

import com.example.demospringint.models.Book;
import com.example.demospringint.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaBookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "SELECT b FROM Book b where id in :ids")
    List<Book> findBooksByIds(@Param(value = "ids") List<Integer> ids);

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.books")
    Page<User> userLeftJoinBook(Pageable pageable);
}
