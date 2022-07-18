package com.example.demospringint.repositories.jdbc;

import com.example.demospringint.models.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class JdbcBookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(timeout = 1)
    public List<Book> hqlfindbyids(List<Integer> ids) {

        Query query = entityManager.createQuery("SELECT b from Book b where b.id in :ids ", Book.class);

        query.setParameter("ids", ids);

        for (int i = 0; i < 999; i++) {
            query.getResultList();
        }
        return query.getResultList();
    }

    @Transactional()
    public List<Book> criteriafindbyids(List<Integer> ids) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Book> criteria = cb.createQuery(Book.class);

        Root<Book> bookRoot = criteria.from(Book.class);

        criteria.select(bookRoot);

        criteria.where(cb.in(bookRoot.get("id")).value(ids));

        return entityManager.createQuery(criteria).getResultList();
    }

}
