package com.projeto.biblioteca_digital.controller;

import com.projeto.biblioteca_digital.entity.Livro;
import com.projeto.biblioteca_digital.entity.form.LivroForm;
import com.projeto.biblioteca_digital.service.impl.LivroServiceImpl;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/livros")
@Validated
public class LivroController {

    @Autowired
    private LivroServiceImpl service;

    @PostMapping
    public ResponseEntity<Livro> create(@Valid @RequestBody LivroForm form) {
        Livro livro = service.create(form);
        return ResponseEntity.status(201).body(livro);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> getAll() {
        List<Livro> livros = service.getAll();
        return ResponseEntity.status(200).body(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Livro>> getOne(@PathVariable Long id){
        Optional<Livro> livro = service.getOne(id);
        return ResponseEntity.status(200).body(livro);
    }

    @GetMapping("/nome={name}")
    public ResponseEntity<List<Livro>> getLivroByNome(@PathVariable String name){
        List<Livro> livros = service.getLivroByNome(name);
        return ResponseEntity.status(200).body(livros);
    }

    @GetMapping("/valor={valor}")
    public ResponseEntity<List<Livro>> getLivroBuscandoValor(@PathVariable String valor){
        List<Livro> livros = service.getLivroBuscandoValor(valor);
        return ResponseEntity.status(200).body(livros);
    }

    @PutMapping
    public ResponseEntity<Livro> update(@Valid @RequestBody LivroForm form) {
        Livro livro = service.update(form);
        return ResponseEntity.status(201).body(livro);
    }

    @Transactional
    @DeleteMapping("/delete={id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(204).build();
    }
}