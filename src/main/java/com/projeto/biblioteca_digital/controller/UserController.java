package com.projeto.biblioteca_digital.controller;

import com.projeto.biblioteca_digital.entity.Book;
import com.projeto.biblioteca_digital.entity.User;
import com.projeto.biblioteca_digital.entity.form.UserForm;
import com.projeto.biblioteca_digital.entity.form.UserLoginForm;
import com.projeto.biblioteca_digital.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody UserForm form){
        return ResponseEntity.status(200).body(service.create(form));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        List<User> users = service.getAll();
        return ResponseEntity.status(200).body(users);
    }

    @GetMapping("/id={id}")
    public ResponseEntity<Optional<User>> getOne(@PathVariable Long id){
        Optional<User> user = service.getOne(id);
        if(user.isPresent()){
            return ResponseEntity.status(200).body(user);
        }else{
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> validateUser(@RequestBody UserLoginForm form){
        Boolean valid = service.validateUser(form);
        if(valid){
            return ResponseEntity.status(200).body("Usuário logado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Nome de usuário ou senha estão incorretos!");
        }
    }

    @Transactional
    @DeleteMapping("/delete={id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(204).build();
    }
}
