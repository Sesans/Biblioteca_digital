package com.projeto.biblioteca_digital.service;

import com.projeto.biblioteca_digital.model.Livro;
import com.projeto.biblioteca_digital.model.form.LivroForm;

import java.util.List;

public interface LivroService {
    Livro create(LivroForm form);

    List<Livro> getAll();

    void delete(Long id);
}
