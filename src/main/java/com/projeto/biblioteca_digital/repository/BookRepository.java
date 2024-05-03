package com.projeto.biblioteca_digital.repository;

import com.projeto.biblioteca_digital.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.name ILIKE %:name%")
    List<Book> getBookByName(@Param("name") String name);

    @Query("SELECT b FROM Book b WHERE b.value <= :value")
    List<Book> getBookByValue(@Param("value") double value);
}
