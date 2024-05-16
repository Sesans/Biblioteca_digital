package com.projeto.biblioteca_digital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private String cpf;
    private String username;
    private String password;
    private String email;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Book> borrowedBooks;

    public void addBorrowedBooks(Book book){
        borrowedBooks.add(book);
    }

    public void removeBorrowedBook(Book book){
        borrowedBooks.remove(book);
    }

}
