package com.projeto.biblioteca_digital.service.impl;

import com.projeto.biblioteca_digital.entity.User;
import com.projeto.biblioteca_digital.repository.UserRepository;
import com.projeto.biblioteca_digital.service.BookService;
import com.projeto.biblioteca_digital.entity.Book;
import com.projeto.biblioteca_digital.entity.form.BookForm;
import com.projeto.biblioteca_digital.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Book create(BookForm form) {
        Book book = new Book();
        book.setName(form.getName());
        book.setDescription(form.getDescription());
        book.setValue(form.getValue());
        book.setUnitsAvailable(form.getUnitsAvailable());
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAll() {   //Busca todos os registros da tabela livro no DB a partir da interface LivroRepository;
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getOne(Long id){
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> getBookByName(String nome) {
        return bookRepository.getBookByName(nome);
    }

    @Override
    public List<Book> getBookByValue(String value) {
        double formatedValue = Double.parseDouble(value);
        return bookRepository.getBookByValue(formatedValue);
    }
    @Override
    public Book update(BookForm form) {
        Book book = new Book();
        book.setName(form.getName());
        book.setDescription(form.getDescription());
        book.setValue(form.getValue());
        return bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        try{
            Optional<Book> optionalBook = bookRepository.findById(id);
            if(optionalBook.isPresent()){
                Book book = optionalBook.get();
                List<User> users = userRepository.findByBorrowedBook(id);
                users.forEach(user -> user.removeBorrowedBook(book));
                bookRepository.deleteById(id);
            }
        } catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }
}
