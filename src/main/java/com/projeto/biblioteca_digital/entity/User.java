package com.projeto.biblioteca_digital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String cpf;
    private String userName;
    private String password;
    private String card;
    private String email;
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Book> borrowedBooks;

    public void addBorrowedBooks(Book book){
        borrowedBooks.add(book);
    }

    public void removeBorrowedBook(Book book){
        borrowedBooks.remove(book);
    }

}
