package com.projeto.biblioteca_digital.service.impl;

import com.projeto.biblioteca_digital.entity.Book;
import com.projeto.biblioteca_digital.entity.User;
import com.projeto.biblioteca_digital.entity.form.UserForm;
import com.projeto.biblioteca_digital.entity.form.UserLoginForm;
import com.projeto.biblioteca_digital.repository.BookRepository;
import com.projeto.biblioteca_digital.repository.UserRepository;
import com.projeto.biblioteca_digital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(){
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public String create(UserForm form) {
        String encoder = this.passwordEncoder.encode(form.getPassword());
        User user = new User();

        if (userRepository.existsByCpf(form.getCpf())) {
            return "CPF já está cadastrado no sistema!";
        } else {
            user.setFullName(form.getFullName());
            user.setCpf(form.getCpf());
            user.setUserName(form.getUserName());
            user.setPassword(encoder);
            user.setCard(form.getCard());
            user.setEmail(form.getEmail());
            userRepository.save(user);
            return "Usuário criado com sucesso!";
        }
    }
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getOne(Long id){
        return userRepository.findById(id);
    }

    @Override
    public Optional<Book> borrowBook(Long userId, Long bookId) {
        try{
            Optional<User> optionalUser = userRepository.findById(userId);
            Optional<Book> optionalBook = bookRepository.findById(bookId);

            if(optionalBook.isPresent() && optionalUser.isPresent()){
                Book book = optionalBook.get();
                User user = optionalUser.get();

                if(book.isAvailable()){
                    user.addBorrowedBooks(book);
                    userRepository.save(user);
                    return Optional.of(book);
                } else{
                    return Optional.empty();
                }
            } else{
                return Optional.empty();
            }
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<Book> returnBook(Long userId, Long bookId) {
        try {
            Optional<User> optionalUser = userRepository.findById(userId);
            Optional<Book> optionalBook = bookRepository.findById(bookId);

            if (optionalUser.isPresent() && optionalBook.isPresent()){
                Book book = optionalBook.get();
                User user = optionalUser.get();

                if(user.getBorrowedBooks().contains(book)){
                    user.removeBorrowedBook(book);
                    userRepository.save(user);
                    return Optional.of(book);
                } else{
                    return Optional.empty();
                }
            } else{
                return Optional.empty();
            }
        } catch (NoSuchElementException e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Boolean validateUser(UserLoginForm form) {
        User user = userRepository.findByEmail(form.getEmail());
        return passwordEncoder.matches(form.getPassword(), user.getPassword());
    }
}
