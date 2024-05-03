package com.projeto.biblioteca_digital.service;

import com.projeto.biblioteca_digital.entity.User;
import com.projeto.biblioteca_digital.entity.form.UserForm;
import com.projeto.biblioteca_digital.entity.form.UserLoginForm;

import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;

public interface UserService {
    String create(UserForm form);

    List<User> getAll();

    Optional<User> getOne(Long id);

    void delete(Long id);

    Boolean validateUser(UserLoginForm form);


}
