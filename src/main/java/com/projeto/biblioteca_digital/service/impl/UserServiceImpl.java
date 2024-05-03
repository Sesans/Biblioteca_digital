package com.projeto.biblioteca_digital.service.impl;

import com.projeto.biblioteca_digital.entity.Book;
import com.projeto.biblioteca_digital.entity.User;
import com.projeto.biblioteca_digital.entity.form.UserForm;
import com.projeto.biblioteca_digital.entity.form.UserLoginForm;
import com.projeto.biblioteca_digital.repository.UserRepository;
import com.projeto.biblioteca_digital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(){
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public String create(UserForm form) {
        String encoder = this.passwordEncoder.encode(form.getPassword());
        User user = new User();

        if (repository.existsByCpf(form.getCpf())) {
            return "CPF já está cadastrado no sistema!";
        } else {
            user.setFullName(form.getFullName());
            user.setCpf(form.getCpf());
            user.setUserName(form.getUserName());
            user.setPassword(encoder);
            user.setCard(form.getCard());
            user.setEmail(form.getEmail());
            repository.save(user);
            return "Usuário criado com sucesso!";
        }
    }
    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<User> getOne(Long id){
        return repository.findById(id);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Boolean validateUser(UserLoginForm form) {
        User user = repository.findByEmail(form.getEmail());
        return passwordEncoder.matches(form.getPassword(), user.getPassword());
    }
}
