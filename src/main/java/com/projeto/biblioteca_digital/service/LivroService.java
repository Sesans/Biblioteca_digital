package com.projeto.biblioteca_digital.service;

import com.projeto.biblioteca_digital.entity.Livro;
import com.projeto.biblioteca_digital.entity.form.LivroForm;
import java.util.List;
import java.util.Optional;

public interface LivroService {
    Livro create(LivroForm form);

    List<Livro> getAll();

    Optional<Livro> getOne(Long id);

    List<Livro> getLivroByNome(String nome);

    List<Livro> getLivroBuscandoValor(String valor);
    void delete(Long id);

    Livro update(LivroForm form);
}
