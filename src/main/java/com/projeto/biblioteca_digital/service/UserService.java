package com.projeto.biblioteca_digital.service;

import com.projeto.biblioteca_digital.entity.Book;
import com.projeto.biblioteca_digital.entity.User;
import com.projeto.biblioteca_digital.entity.form.UserForm;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAll();

    Optional<User> getOne(Long id);

    Optional<Book> borrowBook(Long userId, Long bookId);

    Optional<Book> returnBook(Long userId, Long bookId);

    void delete(Long id);
}
