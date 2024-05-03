package com.projeto.biblioteca_digital.controller;

import com.projeto.biblioteca_digital.entity.Book;
import com.projeto.biblioteca_digital.entity.form.BookForm;
import com.projeto.biblioteca_digital.service.impl.BookServiceImpl;
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
public class BookController {

    @Autowired
    private BookServiceImpl service;

    @PostMapping
    public ResponseEntity<Book> create(@Valid @RequestBody BookForm form) {
        Book book = service.create(form);
        return ResponseEntity.status(201).body(book);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAll() {
        List<Book> books = service.getAll();
        return ResponseEntity.status(200).body(books);
    }

    @GetMapping("/id={id}")
    public ResponseEntity<Optional<Book>> getOne(@PathVariable Long id){
        Optional<Book> book = service.getOne(id);
        if(book.isPresent()){
            return ResponseEntity.status(200).body(book);
        }else{
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/nome={name}")
    public ResponseEntity<List<Book>> getBookByName(@PathVariable String name){
        List<Book> books = service.getBookByName(name);
        return ResponseEntity.status(200).body(books);
    }

    @GetMapping("/valor={valor}")
    public ResponseEntity<List<Book>> getBookByValue(@PathVariable String value){
        List<Book> books = service.getBookByValue(value);
        return ResponseEntity.status(200).body(books);
    }

    @PutMapping
    public ResponseEntity<Book> update(@Valid @RequestBody BookForm form) {
        Book book = service.update(form);
        return ResponseEntity.status(201).body(book);
    }

    @Transactional
    @DeleteMapping("/delete={id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(204).build();
    }
}