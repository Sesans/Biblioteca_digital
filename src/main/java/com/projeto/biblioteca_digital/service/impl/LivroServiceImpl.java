package com.projeto.biblioteca_digital.service.impl;

import com.projeto.biblioteca_digital.service.LivroService;
import com.projeto.biblioteca_digital.model.Livro;
import com.projeto.biblioteca_digital.model.form.LivroForm;
import com.projeto.biblioteca_digital.repository.LivroRepository;

import java.util.List;

public class LivroServiceImpl implements LivroService {

    LivroRepository repository;
    @Override
    public Livro create(LivroForm form) {   //Função irá receber o formulário e salvará no DB a partir da interface LivroRepository;
        Livro livro = new Livro();
        livro.setNome(form.getNome());
        livro.setDescricao(form.getDescricao());
        livro.setValor(form.getValor());
        return repository.save(livro);
    }

    @Override
    public List<Livro> getAll() {   //Busca todos os registros da tabela livro no DB a partir da interface LivroRepository;
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
