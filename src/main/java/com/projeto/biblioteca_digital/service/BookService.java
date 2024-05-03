package com.projeto.biblioteca_digital.service;

import com.projeto.biblioteca_digital.entity.Book;
import com.projeto.biblioteca_digital.entity.form.BookForm;
import java.util.List;
import java.util.Optional;

public interface BookService {
    Book create(BookForm form);

    List<Book> getAll();

    Optional<Book> getOne(Long id);

    List<Book> getBookByName(String nome);

    List<Book> getBookByValue(String valor);
    void delete(Long id);

    Book update(BookForm form);
}
