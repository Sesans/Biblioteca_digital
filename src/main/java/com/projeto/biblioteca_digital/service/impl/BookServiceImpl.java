package com.projeto.biblioteca_digital.service.impl;

import com.projeto.biblioteca_digital.service.BookService;
import com.projeto.biblioteca_digital.entity.Book;
import com.projeto.biblioteca_digital.entity.form.BookForm;
import com.projeto.biblioteca_digital.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repository;
    @Override
    public Book create(BookForm form) {   //Função irá receber o formulário e salvará no DB a partir da interface LivroRepository;
        Book book = new Book();
        book.setName(form.getName());
        book.setDescription(form.getDescription());
        book.setValue(form.getValue());
        book.setUnitsAvailable(form.getUnitsAvailable());
        return repository.save(book);
    }

    @Override
    public List<Book> getAll() {   //Busca todos os registros da tabela livro no DB a partir da interface LivroRepository;
        return repository.findAll();
    }

    @Override
    public Optional<Book> getOne(Long id){
        return repository.findById(id);
    }

    @Override
    public List<Book> getBookByName(String nome) {
        return repository.getBookByName(nome);
    }

    @Override
    public List<Book> getBookByValue(String value) {
        double formatedValue = Double.parseDouble(value);
        return repository.getBookByValue(formatedValue);
    }
    @Override
    public Book update(BookForm form) {
        Book book = new Book();
        book.setName(form.getName());
        book.setDescription(form.getDescription());
        book.setValue(form.getValue());
        return repository.save(book);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
