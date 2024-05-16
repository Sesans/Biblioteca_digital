package com.projeto.biblioteca_digital.controller;

import com.projeto.biblioteca_digital.entity.Book;
import com.projeto.biblioteca_digital.entity.User;
import com.projeto.biblioteca_digital.entity.form.UserForm;
import com.projeto.biblioteca_digital.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@CrossOrigin("*")
@Validated
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/users/add")
    public ResponseEntity<String> create(@Valid @RequestBody UserForm form){
        return ResponseEntity.status(200).body(service.create(form));
    }

    @GetMapping("/users/listar")
    public ResponseEntity<List<User>> getAll(){
        List<User> users = service.getAll();
        return ResponseEntity.status(200).body(users);
    }

    @GetMapping("/users/id={id}")
    public ResponseEntity<Optional<User>> getOne(@PathVariable Long id){
        Optional<User> user = service.getOne(id);
        if(user.isPresent()){
            return ResponseEntity.status(200).body(user);
        }else{
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/users/borrowuser={userId}book={bookId}")
    public ResponseEntity<String> borrowBook(@PathVariable Long userId, @PathVariable Long bookId){
        Optional<Book> book = service.borrowBook(userId, bookId);
        if(book.isPresent()){
            return ResponseEntity.status(200).body("Livro alugado com sucesso!");
        } else{
            return ResponseEntity.status(404).body("Livro indisponível!");
        }
    }

    @GetMapping("/users/returnuser={userId}book={bookId}")
    public ResponseEntity<String> returnBook(@PathVariable Long userId, @PathVariable Long bookId){
        Optional<Book> book = service.returnBook(userId, bookId);
        if(book.isPresent()){
            return ResponseEntity.status(200).body("Livro devolvido com sucesso!");
        } else{
            return ResponseEntity.status(404).body("Livro não estava alugado por este usuário ou não existe!");
        }
    }

    @Transactional
    @DeleteMapping("/users/delete={id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(204).build();
    }
}
